import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
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

public class rkd
  implements VComponentAdapter
{
  private Set<URLDrawable> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  private Bundle a(URLDrawable paramURLDrawable)
  {
    Bundle localBundle = new Bundle();
    if (paramURLDrawable == null) {}
    do
    {
      return null;
      paramURLDrawable = paramURLDrawable.getFileInLocal();
    } while ((paramURLDrawable == null) || (!paramURLDrawable.exists()));
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramURLDrawable.getAbsolutePath(), localOptions);
    localBundle.putInt(ImageAdapterHolder.BUNDLE_WIDTH, localOptions.outWidth);
    localBundle.putInt(ImageAdapterHolder.BUNDLE_HEIGHT, localOptions.outHeight);
    return localBundle;
  }
  
  public static URLDrawable.URLDrawableOptions a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = axwd.a;
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
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 2 < paramString.length()))
      {
        int j = (paramString.charAt(i + 1) - 'A') * 128 + paramString.charAt(i + 2) - 65;
        if (QLog.isColorLevel()) {
          QLog.d("ComponentAdapter", 2, "faceIndex:" + j);
        }
        if ((j >= 0) && (j < awbk.b.length))
        {
          j = awbk.b[j];
          if (j >= 0)
          {
            localStringBuilder.append(paramString.charAt(i));
            localStringBuilder.append((char)j);
          }
        }
        i = i + 1 + 1;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder;
  }
  
  private void a(ImageAction paramImageAction, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramImageAction == null) || (paramImageAction.getTarget() == null) || (paramURLDrawable == null) || (!badq.g(paramImageAction.getTarget().getContext()))) {}
    do
    {
      return;
      localObject = paramURLDrawable.getTag();
    } while (!(localObject instanceof Integer));
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = ((Integer)localObject).intValue();
    if (i < 3)
    {
      i += 1;
      paramURLDrawable.setTag(Integer.valueOf(i));
      paramURLDrawable.restartDownload();
      localObject = localStringBuilder1.append("hit restart download, retryCounts: ").append(i).append(", url: ");
      if (paramURLDrawable.getURL() != null) {}
      for (paramImageAction = paramURLDrawable.getURL().toString();; paramImageAction = "null")
      {
        ((StringBuilder)localObject).append(paramImageAction).append(", errorMsg: ").append(paramThrowable.getMessage());
        ViolaLogUtils.d("ComponentAdapter", localStringBuilder1.toString());
        return;
      }
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append("reach max restart count, ").append(", url: ");
    if (paramURLDrawable.getURL() != null) {}
    for (Object localObject = paramURLDrawable.getURL().toString();; localObject = "null")
    {
      localStringBuilder2.append((String)localObject).append(", errorMsg: ").append(paramThrowable.getMessage());
      paramImageAction.onError();
      this.jdField_a_of_type_JavaUtilSet.remove(paramURLDrawable);
      break;
    }
  }
  
  private void a(ImageAction paramImageAction, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    String str = null;
    if (paramImageAction == null) {
      return;
    }
    if (paramBoolean) {}
    for (Bundle localBundle = a(paramURLDrawable);; localBundle = null)
    {
      if (paramURLDrawable.getURL() != null) {
        str = paramURLDrawable.getURL().toString();
      }
      paramImageAction.onSuccess(paramURLDrawable, str, localBundle);
      return;
    }
  }
  
  private void a(ImageAction paramImageAction, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramImageAction == null) || (TextUtils.isEmpty(paramString)) || (paramImageAction.getTarget() == null)) {}
    do
    {
      return;
      localObject = paramString;
      if (paramString.startsWith("//")) {
        localObject = "https:" + paramString;
      }
    } while (!((String)localObject).startsWith("http"));
    paramString = URLDrawable.getDrawable((String)localObject, a(paramBoolean2, paramInt1, paramInt2));
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentAdapter", 2, "enqueue action, url: " + (String)localObject + ", " + paramImageAction.getTarget().hashCode());
    }
    Object localObject = paramString.getFileInLocal();
    if ((localObject != null) && (((File)localObject).exists()))
    {
      a(paramImageAction, paramString, paramBoolean1);
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      return;
    }
    paramString.startDownload();
    paramString.setTag(Integer.valueOf(0));
    paramString.setURLDrawableListener(new rkf(this, paramBoolean1, paramImageAction));
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty())) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void initKdRefresh(VRefreshLayout paramVRefreshLayout)
  {
    PullRefreshHeader localPullRefreshHeader = (PullRefreshHeader)LayoutInflater.from(paramVRefreshLayout.getContext()).inflate(2131496707, paramVRefreshLayout, false);
    RefreshAnimView localRefreshAnimView = (RefreshAnimView)localPullRefreshHeader.findViewById(2131309301);
    paramVRefreshLayout.addView(localPullRefreshHeader);
    paramVRefreshLayout.setonRefreshStateChangeListener(new rke(this, localRefreshAnimView, paramVRefreshLayout));
  }
  
  public void requestImage(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, ImageAction paramImageAction, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramImageAction == null) || (paramImageAction.getTarget() == null)) {
      return;
    }
    if ((paramInt2 == 0) || (paramInt1 == 0)) {
      ViolaLogUtils.d("ComponentAdapter", "width: " + paramInt1 + ", height: " + paramInt2 + ", url: " + paramString);
    }
    a(paramImageAction, paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public CharSequence setEmoticonText(@NonNull CharSequence paramCharSequence, int paramInt)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return "";
    }
    return new axkd(a(paramCharSequence.toString()), 2, (int)(paramInt / 2.5D));
  }
  
  public void setImage(String paramString, VImageView paramVImageView, ImageAdapterHolder paramImageAdapterHolder, ViolaInstance paramViolaInstance, boolean paramBoolean) {}
  
  public void setImgSpan(String paramString, int paramInt1, int paramInt2, ImageAdapterHolder paramImageAdapterHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rkd
 * JD-Core Version:    0.7.0.1
 */