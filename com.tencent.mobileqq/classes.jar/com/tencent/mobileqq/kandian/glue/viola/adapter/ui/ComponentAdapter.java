package com.tencent.mobileqq.kandian.glue.viola.adapter.ui;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaDatongReportUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.commons.ImageAdapterHolder;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.component.image.ImageAction;
import com.tencent.viola.ui.view.VImageView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.utils.ViolaLogUtils;
import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class ComponentAdapter
  implements VComponentAdapter
{
  private Set<URLDrawable> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = false;
  
  private Bundle a(URLDrawable paramURLDrawable)
  {
    Bundle localBundle = new Bundle();
    if (paramURLDrawable == null) {
      return null;
    }
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if (paramURLDrawable != null)
    {
      if (!paramURLDrawable.exists()) {
        return null;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramURLDrawable.getAbsolutePath(), localOptions);
      localBundle.putInt(ImageAdapterHolder.BUNDLE_WIDTH, localOptions.outWidth);
      localBundle.putInt(ImageAdapterHolder.BUNDLE_HEIGHT, localOptions.outHeight);
      return localBundle;
    }
    return null;
  }
  
  public static URLDrawable.URLDrawableOptions a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    if (paramBoolean)
    {
      AbstractGifImage.resumeAll();
      localURLDrawableOptions.mPlayGifImage = true;
      return localURLDrawableOptions;
    }
    localURLDrawableOptions.mPlayGifImage = false;
    return localURLDrawableOptions;
  }
  
  private static StringBuilder a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) == '\024')
      {
        int k = i + 2;
        if (k < paramString.length())
        {
          int j = i + 1;
          k = (paramString.charAt(j) - 'A') * 128 + paramString.charAt(k) - 65;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("faceIndex:");
            localStringBuilder2.append(k);
            QLog.d("ComponentAdapter", 2, localStringBuilder2.toString());
          }
          k = QQSysFaceUtil.convertToLocal(k);
          if (k >= 0)
          {
            localStringBuilder1.append(paramString.charAt(i));
            localStringBuilder1.append((char)k);
          }
          i = j + 1;
          break label154;
        }
      }
      localStringBuilder1.append(paramString.charAt(i));
      label154:
      i += 1;
    }
    return localStringBuilder1;
  }
  
  private void a(ImageAction paramImageAction, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramImageAction != null) && (paramImageAction.getTarget() != null) && (paramURLDrawable != null))
    {
      if (!NetworkUtil.isNetworkAvailable(paramImageAction.getTarget().getContext())) {
        return;
      }
      Object localObject = paramURLDrawable.getTag();
      if ((localObject instanceof Integer))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = ((Integer)localObject).intValue();
        localObject = "null";
        if (i < 3)
        {
          i += 1;
          paramURLDrawable.setTag(Integer.valueOf(i));
          paramURLDrawable.restartDownload();
          localStringBuilder.append("hit restart download, retryCounts: ");
          localStringBuilder.append(i);
          localStringBuilder.append(", url: ");
          if (paramURLDrawable.getURL() != null) {
            localObject = paramURLDrawable.getURL().toString();
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", errorMsg: ");
          localStringBuilder.append(paramThrowable.getMessage());
        }
        else
        {
          localStringBuilder.append("reach max restart count, ");
          localStringBuilder.append(", url: ");
          if (paramURLDrawable.getURL() != null) {
            localObject = paramURLDrawable.getURL().toString();
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", errorMsg: ");
          localStringBuilder.append(paramThrowable.getMessage());
          paramImageAction.onError();
          this.jdField_a_of_type_JavaUtilSet.remove(paramURLDrawable);
        }
        ViolaLogUtils.d("ComponentAdapter", localStringBuilder.toString());
      }
    }
  }
  
  private void a(ImageAction paramImageAction, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    a(paramImageAction, paramURLDrawable, paramBoolean, null);
  }
  
  private void a(ImageAction paramImageAction, URLDrawable paramURLDrawable, boolean paramBoolean, String paramString)
  {
    if (paramImageAction == null) {
      return;
    }
    Bundle localBundle;
    if (paramBoolean) {
      localBundle = a(paramURLDrawable);
    } else {
      localBundle = null;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      if (paramURLDrawable.getURL() != null) {
        str = paramURLDrawable.getURL().toString();
      } else {
        str = null;
      }
    }
    paramImageAction.onSuccess(paramURLDrawable, str, localBundle);
  }
  
  private void a(ImageAction paramImageAction, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramImageAction != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramImageAction.getTarget() == null) {
        return;
      }
      Object localObject = paramString;
      if (paramString.startsWith("//"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https:");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
      if (a(paramImageAction, (String)localObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2)) {
        return;
      }
      if (!((String)localObject).startsWith("http")) {
        return;
      }
      if (a(paramImageAction, (String)localObject, paramBoolean1)) {
        return;
      }
      paramString = URLDrawable.getDrawable((String)localObject, a(paramBoolean2, paramInt1, paramInt2));
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enqueue action, url: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramImageAction.getTarget().hashCode());
        QLog.d("ComponentAdapter", 2, localStringBuilder.toString());
      }
      localObject = paramString.getFileInLocal();
      if ((localObject != null) && (((File)localObject).exists()))
      {
        a(paramImageAction, paramString, paramBoolean1);
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
        return;
      }
      paramString.startDownload();
      paramString.setTag(Integer.valueOf(0));
      paramString.setURLDrawableListener(new ComponentAdapter.ViolaImageListener(this, paramBoolean1, paramImageAction));
    }
  }
  
  private boolean a(ImageAction paramImageAction, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.contains("item_image_width")) {
      return false;
    }
    Object localObject2 = Uri.parse(paramString);
    Object localObject1 = ((Uri)localObject2).getQueryParameter("item_image_width");
    String str = ((Uri)localObject2).getQueryParameter("item_image_height");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      try
      {
        int j = paramString.indexOf("?item_image_width");
        int i = j;
        if (j == -1) {
          i = paramString.indexOf("&item_image_width");
        }
        localObject2 = paramString.substring(0, i);
        i = Integer.parseInt((String)localObject1);
        j = Integer.parseInt(str);
        localObject1 = new ImageRequest();
        ((ImageRequest)localObject1).jdField_a_of_type_JavaNetURL = new URL((String)localObject2);
        ((ImageRequest)localObject1).jdField_a_of_type_Int = i;
        ((ImageRequest)localObject1).b = j;
        localObject2 = ImageManager.get().getBitmap((ImageRequest)localObject1);
        if (localObject2 != null)
        {
          if (((ICloseableBitmap)localObject2).a() == null) {
            return false;
          }
          localObject1 = null;
          if (paramBoolean)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt(ImageAdapterHolder.BUNDLE_WIDTH, i);
            ((Bundle)localObject1).putInt(ImageAdapterHolder.BUNDLE_HEIGHT, j);
          }
          paramImageAction.onSuccess(((ICloseableBitmap)localObject2).a(), paramString, (Bundle)localObject1);
          return true;
        }
        return false;
      }
      catch (Exception paramImageAction)
      {
        paramString = new StringBuilder();
        paramString.append("parse view width and height error: ");
        paramString.append(paramImageAction.getMessage());
        ViolaLogUtils.e("ComponentAdapter", paramString.toString());
      }
    }
    return false;
  }
  
  private boolean a(ImageAction paramImageAction, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (paramString.startsWith("file://"))
    {
      Object localObject = paramString.substring(7);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = URLDrawable.getFileDrawable((String)localObject, a(paramBoolean2, paramInt1, paramInt2));
        if (localObject != null)
        {
          a(paramImageAction, (URLDrawable)localObject, paramBoolean1, paramString);
          return true;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("load local file error, url: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("ComponentAdapter", 1, ((StringBuilder)localObject).toString());
        paramImageAction.onError();
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    Set localSet = this.jdField_a_of_type_JavaUtilSet;
    if ((localSet != null) && (!localSet.isEmpty())) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void initKdRefresh(VRefreshLayout paramVRefreshLayout)
  {
    PullRefreshHeader localPullRefreshHeader = (PullRefreshHeader)LayoutInflater.from(paramVRefreshLayout.getContext()).inflate(2131562705, paramVRefreshLayout, false);
    RefreshAnimView localRefreshAnimView = (RefreshAnimView)localPullRefreshHeader.findViewById(2131376336);
    localRefreshAnimView.setRefreshBarStayTimeMS(Aladdin.getConfig(222).getIntegerFromString("refresh_bar_text_delay_time", 100));
    paramVRefreshLayout.addView(localPullRefreshHeader);
    paramVRefreshLayout.setonRefreshStateChangeListener(new ComponentAdapter.1(this, localRefreshAnimView, paramVRefreshLayout));
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    ViolaDatongReportUtils.a(paramView, paramObject);
  }
  
  public void onDoubleClick(View paramView, Object paramObject)
  {
    ViolaDatongReportUtils.a(paramView, paramObject);
  }
  
  public void onVRParamsChange(View paramView, Object paramObject)
  {
    ViolaDatongReportUtils.a(paramView, paramObject);
  }
  
  public void requestImage(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, ImageAction paramImageAction, boolean paramBoolean2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramImageAction != null))
    {
      if (paramImageAction.getTarget() == null) {
        return;
      }
      if ((paramInt2 == 0) || (paramInt1 == 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("width: ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", height: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", url: ");
        localStringBuilder.append(paramString);
        ViolaLogUtils.d("ComponentAdapter", localStringBuilder.toString());
      }
      a(paramImageAction, paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
  }
  
  public CharSequence setEmoticonText(@NonNull CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return "";
    }
    try
    {
      paramCharSequence = a(paramCharSequence.toString());
      if (paramInt2 == -1.0F)
      {
        double d = paramInt1;
        Double.isNaN(d);
        paramInt2 = (int)(d / 2.5D);
      }
      paramCharSequence = new QQText(paramCharSequence, 2, paramInt2);
      return paramCharSequence;
    }
    catch (Throwable paramCharSequence)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEmoticonTextError: ");
      localStringBuilder.append(paramCharSequence.getMessage());
      QLog.e("ComponentAdapter", 1, localStringBuilder.toString());
    }
    return "";
  }
  
  public void setImage(String paramString, VImageView paramVImageView, ImageAdapterHolder paramImageAdapterHolder, ViolaInstance paramViolaInstance, boolean paramBoolean) {}
  
  public void setImgSpan(String paramString, int paramInt1, int paramInt2, ImageAdapterHolder paramImageAdapterHolder) {}
  
  public void setVRElementReuseIdentifier(View paramView, String paramString)
  {
    if (paramView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      VideoReport.setElementReuseIdentifier(paramView, paramString);
    }
  }
  
  public boolean useCustomFont(TextPaint paramTextPaint, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramTextPaint == null) {
        return false;
      }
      String str = null;
      if (paramString.equals("DIN")) {
        str = "fonts/DIN Alternate.ttf";
      } else if (paramString.equals("bebas")) {
        str = "fonts/readinjoy_operation_bar_number.ttf";
      } else if ("din-black".equals(paramString)) {
        str = "fonts/DINBlack.ttf";
      }
      if (str == null) {
        return false;
      }
      paramString = Typeface.createFromAsset(BaseApplicationImpl.getApplication().getAssets(), str);
      if (paramString == null) {
        return false;
      }
      paramTextPaint.setTypeface(paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter
 * JD-Core Version:    0.7.0.1
 */