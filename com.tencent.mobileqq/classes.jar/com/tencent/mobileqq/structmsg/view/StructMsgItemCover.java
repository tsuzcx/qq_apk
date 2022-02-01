package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.ViewCache;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.HttpDownloaderParams;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemCover
  extends AbsStructMsgElement
{
  public static int q = 1;
  public static int r = 2;
  public static int s = 3;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  public String ac;
  public String ad;
  public int o;
  public int p;
  public int t = s;
  
  public StructMsgItemCover()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new StructMsgItemCover.1(this);
    this.jdField_a_of_type_JavaLangString = "picture";
    this.jdField_a_of_type_Int = 19;
  }
  
  public StructMsgItemCover(String paramString)
  {
    this();
    this.ac = paramString;
  }
  
  public StructMsgItemCover(String paramString1, String paramString2)
  {
    this();
    this.ac = paramString1;
    this.ad = paramString2;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    try
    {
      int i = paramDrawable.getIntrinsicWidth();
      if (paramDrawable.getOpacity() != -1) {}
      for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
      {
        localObject = Bitmap.createBitmap(i, i, (Bitmap.Config)localObject);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, i, i);
        paramDrawable.draw(localCanvas);
        paramDrawable = ImageUtil.a((Bitmap)localObject, i, i, i);
        ((Bitmap)localObject).recycle();
        return paramDrawable;
      }
      return null;
    }
    catch (Exception paramDrawable)
    {
      return null;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      QLog.e("StructMsgItemCover", 2, "getRoundedCornerBitmap  OutOfMemoryError");
    }
  }
  
  private URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    try
    {
      Object localObject1 = new URL(paramString);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramDrawable1;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = paramDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = paramBoolean1;
      ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 0.0F;
      ((URLDrawable.URLDrawableOptions)localObject2).mNeedCheckNetType = paramBoolean2;
      ((URLDrawable.URLDrawableOptions)localObject2).mRetryCount = 3;
      ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = paramObject;
      paramString = new HttpDownloaderParams();
      paramString.businessType = 1001;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        paramString.param1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID;
        paramString.param2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgTemplateID;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
          paramString.param3 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.istroop);
        }
      }
      ((URLDrawable.URLDrawableOptions)localObject2).mHttpDownloaderParams = paramString;
      localObject2 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      if ("url.cn".equals(((URL)localObject1).getHost()))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramDrawable1;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramDrawable2;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = paramBoolean1;
        ((URLDrawable.URLDrawableOptions)localObject1).mGifRoundCorner = 0.0F;
        ((URLDrawable.URLDrawableOptions)localObject1).mNeedCheckNetType = paramBoolean2;
        ((URLDrawable.URLDrawableOptions)localObject1).mRetryCount = 3;
        ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = paramObject;
        ((URLDrawable.URLDrawableOptions)localObject1).mHttpDownloaderParams = paramString;
        ((URLDrawable)localObject2).setTag(localObject1);
      }
      return localObject2;
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, false, paramBundle);
  }
  
  public View a(Context paramContext, View paramView, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("[@]", 2, "StructMsgItemCover createView start! mUrlString = " + this.ac);
    }
    boolean bool2;
    if (paramBundle != null) {
      bool2 = paramBundle.getBoolean("pre_dialog");
    }
    boolean bool1;
    Object localObject3;
    int i;
    Object localObject1;
    Object localObject2;
    Drawable localDrawable2;
    for (;;)
    {
      if (paramBundle == null) {
        break label2028;
      }
      bool1 = paramBundle.getBoolean("pa_should_change");
      localObject3 = paramContext.getResources();
      i = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      try
      {
        Drawable localDrawable1 = ViewCache.a().a((Resources)localObject3, 2130850894);
        if ((paramView != null) && ((paramView instanceof PAImageView)))
        {
          localObject1 = (PAHighLightImageView)paramView;
          localObject2 = paramView;
          ((PAHighLightImageView)localObject1).setTag(this);
          paramView = this.ac;
          if ((TextUtils.isEmpty(paramView)) && (paramBundle != null) && (paramBundle.containsKey("extend-data-json")) && (paramBundle.getInt("serviceID", 0) == 128))
          {
            paramBundle = paramBundle.getString("extend-data-json");
            if (TextUtils.isEmpty(paramBundle)) {}
          }
        }
        else
        {
          try
          {
            if (!(paramContext instanceof BaseActivity)) {
              break label317;
            }
            paramBundle = new JSONObject(paramBundle);
            ((PAHighLightImageView)localObject1).setImageDrawable(FaceDrawable.getFaceDrawable(((BaseActivity)paramContext).app, 4, paramBundle.optString("groupcode")));
            ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
            return localObject2;
          }
          catch (Throwable paramContext)
          {
            QLog.d("StructMsgItemCover", 1, "createView error:" + paramContext.getMessage());
          }
          bool2 = false;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localDrawable2 = null;
          continue;
          localObject2 = new FixRatioPAHighLightImageView(paramContext);
          ((PAHighLightImageView)localObject2).setId(2131368907);
          ((PAHighLightImageView)localObject2).setContentDescription(((Resources)localObject3).getString(2131691326));
          localObject1 = localObject2;
        }
      }
    }
    label317:
    if (TextUtils.isEmpty(paramView))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[@]", 2, "StructMsgItemCover createView ,url = " + paramView);
      }
      ((PAHighLightImageView)localObject1).setImageDrawable(localDrawable2);
      ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (bool1) {
        ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe2"));
      }
      for (;;)
      {
        if ((this.c != null) && (!this.c.equals("")))
        {
          ((View)localObject2).setClickable(true);
          ((View)localObject2).setOnClickListener(this);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("[@]", 2, "StructMsgItemCover createView end!");
        return localObject2;
        ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe4"));
      }
    }
    label387:
    label552:
    label632:
    label2045:
    for (;;)
    {
      int j;
      try
      {
        if ((paramView.startsWith("http://")) || (paramView.startsWith("https://"))) {
          break label1230;
        }
        boolean bool3 = paramView.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2));
        if (bool3) {
          break label1230;
        }
        try
        {
          if (!paramView.startsWith("mqqapi://card")) {
            break label1111;
          }
          i = paramView.lastIndexOf("&uin=");
          if (i != -1) {
            break label758;
          }
          if (QLog.isColorLevel()) {
            QLog.e("StructMsgItemCover", 2, "createView, error: index is -1");
          }
          ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.d());
          return localObject2;
        }
        catch (MalformedURLException paramContext)
        {
          i = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.e("StructMsgItemCover", 2, "createView, error: " + paramContext.getMessage());
        }
        ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.d());
        paramContext = null;
        if ((paramContext == null) || (paramContext.getStatus() != 1)) {
          break label1957;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,set null");
        }
        ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (paramBoolean) {
          ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
        }
        if ((paramContext == null) || (!paramBoolean)) {
          break label1984;
        }
        j = i;
        if (i == 0) {
          j = paramContext.getIntrinsicWidth();
        }
        paramContext.setTag(URLDrawableDecodeHandler.b(j, j, j));
        paramContext.setDecodeHandler(URLDrawableDecodeHandler.j);
        ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
        if (paramContext.getStatus() == 1) {
          break label387;
        }
        paramContext.restartDownload();
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label748;
        }
      }
      if ("StructMsgItemCover createView ,exception  = " + paramContext != null)
      {
        paramContext = paramContext.getMessage();
        QLog.d("StructMsgItemCover", 2, paramContext);
        ((PAHighLightImageView)localObject1).setImageDrawable(localDrawable2);
        break label387;
        paramContext = paramView.substring("&uin=".length() + i);
        i = paramContext.lastIndexOf("&");
        paramBundle = paramContext;
        if (i != -1) {
          paramBundle = paramContext.substring(0, i);
        }
        if (localObject2 != null)
        {
          localObject3 = ((View)localObject2).getContext();
          if ((localObject3 instanceof BaseActivity))
          {
            ((PAHighLightImageView)localObject1).e = "";
            QQAppInterface localQQAppInterface = ((BaseActivity)localObject3).app;
            paramContext = ImageUtil.d();
            if (paramView.indexOf("internal_phone") > -1)
            {
              i = paramView.indexOf("&headtext=");
              paramContext = "";
              if (i != -1)
              {
                j = paramView.indexOf("&", i + 1);
                if (j == -1) {
                  paramContext = paramView.substring("&headtext=".length() + i);
                }
              }
              else
              {
                paramContext = URLDecoder.decode(paramContext);
                if (TextUtils.isEmpty(paramContext.trim())) {
                  break label1052;
                }
                if (!bool2) {
                  break label1013;
                }
                if (!ContactUtils.a(paramContext)) {
                  break label997;
                }
                i = ((Context)localObject3).getResources().getDimensionPixelSize(2131299111);
                ((PAHighLightImageView)localObject1).setTextSize(i);
                ((PAHighLightImageView)localObject1).e = paramContext;
                paramContext = ((Context)localObject3).getResources().getDrawable(2130842261);
              }
            }
            for (;;)
            {
              ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
              return localObject2;
              paramContext = paramView.substring(i + "&headtext=".length(), j);
              break;
              i = ((Context)localObject3).getResources().getDimensionPixelSize(2131299113);
              break label944;
              if (ContactUtils.a(paramContext))
              {
                i = ((Context)localObject3).getResources().getDimensionPixelSize(2131299107);
                break label944;
              }
              i = ((Context)localObject3).getResources().getDimensionPixelSize(2131299109);
              break label944;
              if (paramBundle.startsWith("+"))
              {
                paramContext = FaceDrawable.getMobileFaceDrawable(localQQAppInterface, paramBundle, (byte)3);
              }
              else
              {
                paramContext = FaceDrawable.getDefaultDrawable(11, 3);
                continue;
                paramContext = FaceDrawable.getFaceDrawable(localQQAppInterface, 1, paramBundle, 3, paramContext, paramContext);
              }
            }
          }
        }
        ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.d());
        return localObject2;
        if (paramView.startsWith("troop_notice"))
        {
          ((PAHighLightImageView)localObject1).setImageResource(2130844106);
          return localObject2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,begin decode");
        }
        paramContext = new File(paramView).toURL().toString();
        for (;;)
        {
          for (;;)
          {
            try
            {
              if (this.t == q)
              {
                j = AIOUtils.a(70.0F, (Resources)localObject3);
                i = j;
              }
            }
            catch (MalformedURLException paramContext) {}
            try
            {
              paramContext = URLDrawable.getDrawable(paramContext, i, i, localDrawable2, localDrawable2, true);
            }
            catch (MalformedURLException paramContext) {}
          }
          if (this.t != r) {
            break label2025;
          }
          j = AIOUtils.a(140.0F, (Resources)localObject3);
          i = j;
          continue;
          paramBundle = null;
          if (paramView.startsWith("https://p.qlogo.cn/gh/"))
          {
            j = paramView.lastIndexOf("gh/");
            paramContext = paramView.substring("gh/".length() + j).split("/")[0];
            if (TextUtils.isEmpty(paramContext)) {
              break label2034;
            }
            paramView = ((View)localObject2).getContext();
            if ((paramView instanceof BaseActivity))
            {
              paramView = ((BaseActivity)paramView).app;
              paramBundle = FaceDrawable.getDefaultDrawable(4, 3);
              ((PAHighLightImageView)localObject1).setImageDrawable(FaceDrawable.getFaceDrawable(paramView, 4, paramContext, 3, paramBundle, paramBundle));
              return localObject2;
            }
            ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.d());
            return localObject2;
          }
        }
      }
      for (;;)
      {
        if (this.t == q)
        {
          ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
          i = AIOUtils.a(70.0F, (Resources)localObject3);
          if (!bool1) {
            break label1943;
          }
          ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe2"));
        }
        for (;;)
        {
          paramContext = a(paramContext, i, i, localDrawable2, localDrawable2, true, true, paramView);
          if (paramContext.getTag() == null) {
            paramContext.setTag(Integer.valueOf(0));
          }
          paramContext.setAutoDownload(true);
          if (paramContext.getStatus() != 2) {
            break label2045;
          }
          paramContext.restartDownload();
          break label2045;
          if ((paramView.startsWith(ShareActionSheet.b)) || (paramView.startsWith(ShareActionSheet.c)) || (paramView.startsWith(ShareActionSheet.d)))
          {
            ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
            i = paramView.lastIndexOf("&uin=");
            paramContext = paramView.substring("&uin=".length() + i);
            paramView = ((View)localObject2).getContext();
            if ((paramView instanceof BaseActivity))
            {
              ((PAHighLightImageView)localObject1).setImageDrawable(((BaseActivity)paramView).app.getFaceDrawable(paramContext, false, (byte)4));
              return localObject2;
            }
            ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.d());
            return localObject2;
          }
          if (paramView.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2)))
          {
            paramContext = new ColorDrawable(0);
            ((PAHighLightImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramView, paramContext, paramContext));
            return localObject2;
          }
          if ((paramView.startsWith("http://imgplat.store.qq.com/bqq_qfpic/520520")) || (paramView.contains(SubscribeShareHelper.jdField_a_of_type_JavaLangString)))
          {
            paramBoolean = true;
            this.jdField_a_of_type_Boolean = true;
            paramBundle = null;
            paramContext = paramView;
            paramView = paramBundle;
            break;
          }
          if ((this.ad != null) && (this.ad.equals("1")))
          {
            paramBoolean = true;
            this.jdField_a_of_type_Boolean = true;
            paramBundle = null;
            paramContext = paramView;
            paramView = paramBundle;
            break;
          }
          bool2 = paramView.startsWith("http://qqpublic.qpic.cn");
          if (bool2)
          {
            for (;;)
            {
              for (;;)
              {
                try
                {
                  if (new URL(paramView).getQuery() != null)
                  {
                    paramContext = "&spec=screen";
                    if (this.t == q)
                    {
                      paramContext = "&spec=small";
                      new String(paramView);
                      paramContext = paramView + paramContext;
                      paramView = paramBundle;
                    }
                  }
                }
                catch (MalformedURLException paramContext) {}
                try
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
                  {
                    paramView = paramBundle;
                    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
                      paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
                    }
                  }
                }
                catch (MalformedURLException paramView)
                {
                  for (;;)
                  {
                    paramView = paramContext;
                  }
                }
              }
              if (this.t == r)
              {
                paramContext = "&spec=middle";
                continue;
                paramContext = "?spec=screen";
                if (this.t == q) {
                  paramContext = "?spec=small";
                } else if (this.t == r) {
                  paramContext = "?spec=middle";
                }
              }
            }
            throw new IllegalArgumentException("illegal url format: " + paramView);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.istroop != 1008)) {
            break label2014;
          }
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
          paramContext = paramView;
          paramView = paramBundle;
          break;
          if (this.t == r)
          {
            ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
            i = AIOUtils.a(140.0F, (Resources)localObject3);
            break label1367;
          }
          ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
          break label1367;
          ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe4"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,set listener");
        }
        ((PAHighLightImageView)localObject1).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        break label632;
        ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
        break label387;
        paramContext = " happens error ";
        break label741;
        break label552;
        break label552;
        paramBundle = null;
        paramContext = paramView;
        paramView = paramBundle;
        continue;
        break label1186;
        bool1 = false;
        break;
        paramBundle = null;
        paramContext = paramView;
        paramView = paramBundle;
      }
    }
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131378578) {
        return (StructMsgForGeneralShare)paramView.getTag(2131378578);
      }
    }
    return null;
  }
  
  public String a()
  {
    return "Cover";
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = AIOUtils.a(paramView);
      localObject1 = localObject2;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject2;
      label13:
      Object localObject3;
      break label13;
    }
    if (localObject1 == null) {}
    do
    {
      return;
      localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
    } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (!this.ac.endsWith("gif")));
    localObject1 = "0";
    localObject2 = ((FragmentActivity)paramView.getContext()).getChatFragment();
    if (localObject2 == null) {}
    for (localObject2 = null;; localObject2 = ((ChatFragment)localObject2).a())
    {
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        if (((JSONObject)localObject3).has("ad_id")) {
          localObject1 = ((JSONObject)localObject3).getString("ad_id");
        }
      }
      catch (Exception localException)
      {
        String str;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("StructMsgItemCover", 2, "parse ad_id error");
          }
          str = "0";
        }
        ReportController.b((AppRuntime)localObject2, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, str, String.valueOf(paramView.msgId), "1", "");
        return;
      }
      paramView = a(paramView);
      if (paramView != null) {
        break label168;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StructMsgItemCover", 2, "StructMsgForGeneralShare == NULL");
      return;
    }
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentCover = this.ac;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ac = paramObjectInput.readUTF();
    if (this.jdField_a_of_type_Int <= 3) {}
    do
    {
      do
      {
        return;
        this.c = paramObjectInput.readUTF();
        this.b = paramObjectInput.readUTF();
      } while (this.jdField_a_of_type_Int <= 5);
      this.j = paramObjectInput.readUTF();
      this.k = paramObjectInput.readUTF();
      this.l = paramObjectInput.readUTF();
      this.o = paramObjectInput.readInt();
      this.p = paramObjectInput.readInt();
    } while (this.jdField_a_of_type_Int <= 8);
    this.ad = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ac == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.jdField_a_of_type_Int > 3) {
        break label40;
      }
    }
    label40:
    label69:
    label95:
    label113:
    do
    {
      do
      {
        return;
        str = this.ac;
        break;
        if (this.c != null) {
          break label186;
        }
        str = "";
        paramObjectOutput.writeUTF(str);
        if (this.b != null) {
          break label194;
        }
        str = "";
        paramObjectOutput.writeUTF(str);
      } while (this.jdField_a_of_type_Int <= 5);
      if (this.j != null) {
        break label202;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.k != null) {
        break label210;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.l != null) {
        break label218;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.o);
      paramObjectOutput.writeInt(this.p);
    } while (this.jdField_a_of_type_Int <= 8);
    label131:
    if (this.ad == null) {}
    for (String str = "";; str = this.ad)
    {
      paramObjectOutput.writeUTF(str);
      return;
      label186:
      str = this.c;
      break;
      label194:
      str = this.b;
      break label69;
      label202:
      str = this.j;
      break label95;
      label210:
      str = this.k;
      break label113;
      label218:
      str = this.l;
      break label131;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.ac == null) {}
    for (String str = "";; str = this.ac)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      if (this.jdField_a_of_type_Int > 3)
      {
        if (!TextUtils.isEmpty(this.c)) {
          paramXmlSerializer.attribute(null, "action", this.c);
        }
        if (!TextUtils.isEmpty(this.b)) {
          paramXmlSerializer.attribute(null, "url", this.b);
        }
        if (this.jdField_a_of_type_Int > 5)
        {
          if (!TextUtils.isEmpty(this.j)) {
            paramXmlSerializer.attribute(null, "index", this.j);
          }
          if (!TextUtils.isEmpty(this.k)) {
            paramXmlSerializer.attribute(null, "index_name", this.k);
          }
          if (!TextUtils.isEmpty(this.l)) {
            paramXmlSerializer.attribute(null, "index_type", this.l);
          }
          paramXmlSerializer.attribute(null, "w", String.valueOf(this.o));
          paramXmlSerializer.attribute(null, "h", String.valueOf(this.p));
          if ((this.jdField_a_of_type_Int > 8) && (!TextUtils.isEmpty(this.ad))) {
            paramXmlSerializer.attribute(null, "needRoundView", this.ad);
          }
        }
      }
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    String str;
    label18:
    do
    {
      do
      {
        return true;
        str = paramStructMsgNode.a("cover");
        if (str == null) {
          break;
        }
        this.ac = str;
      } while (this.jdField_a_of_type_Int <= 3);
      this.c = paramStructMsgNode.a("action");
      this.b = paramStructMsgNode.a("url");
    } while (this.jdField_a_of_type_Int <= 5);
    this.j = paramStructMsgNode.a("index");
    this.k = paramStructMsgNode.a("index_name");
    this.l = paramStructMsgNode.a("index_type");
    for (;;)
    {
      try
      {
        str = paramStructMsgNode.a("w");
        if (str != null) {
          continue;
        }
        i = 0;
        this.o = i;
        str = paramStructMsgNode.a("h");
        if (str != null) {
          continue;
        }
        i = 0;
        this.p = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i;
        this.o = 0;
        this.p = 0;
        continue;
      }
      if (this.jdField_a_of_type_Int <= 8) {
        break;
      }
      this.ad = paramStructMsgNode.a("needRoundView");
      return true;
      str = "";
      break label18;
      i = Integer.parseInt(str);
      continue;
      i = Integer.parseInt(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemCover
 * JD-Core Version:    0.7.0.1
 */