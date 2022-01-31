package com.tencent.mobileqq.structmsg.view;

import aiip;
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
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemCover
  extends AbsStructMsgElement
{
  public static int g = 1;
  public static int h = 2;
  public static int i = 3;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  public int e;
  public int f;
  public int j;
  public String u;
  public String v;
  
  public StructMsgItemCover()
  {
    this.jdField_j_of_type_Int = i;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new aiip(this);
    this.jdField_a_of_type_JavaLangString = "picture";
    this.jdField_a_of_type_Int = 11;
  }
  
  public StructMsgItemCover(String paramString)
  {
    this();
    this.u = paramString;
  }
  
  public StructMsgItemCover(String paramString1, String paramString2)
  {
    this();
    this.u = paramString1;
    this.v = paramString2;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    try
    {
      int k = paramDrawable.getIntrinsicWidth();
      if (paramDrawable.getOpacity() != -1) {}
      for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
      {
        localObject = Bitmap.createBitmap(k, k, (Bitmap.Config)localObject);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, k, k);
        paramDrawable.draw(localCanvas);
        paramDrawable = ImageUtil.a((Bitmap)localObject, k, k, k);
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
      paramString.jdField_a_of_type_Int = 1001;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        paramString.b = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID;
        paramString.c = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgTemplateID;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
          paramString.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.istroop);
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
      QLog.d("[@]", 2, "StructMsgItemCover createView start! mUrlString = " + this.u);
    }
    boolean bool2;
    if (paramBundle != null) {
      bool2 = paramBundle.getBoolean("pre_dialog");
    }
    boolean bool1;
    Object localObject4;
    int k;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (paramBundle != null)
      {
        bool1 = paramBundle.getBoolean("pa_should_change");
        localObject4 = paramContext.getResources();
        k = ((Resources)localObject4).getDisplayMetrics().widthPixels;
        try
        {
          paramBundle = ViewCache.a().a((Resources)localObject4, 2130846093);
          if ((paramView != null) && ((paramView instanceof PAImageView)))
          {
            localObject1 = (PAHighLightImageView)paramView;
            localObject2 = paramView;
            ((PAHighLightImageView)localObject1).setTag(this);
            paramContext = this.u;
            if (!TextUtils.isEmpty(paramContext)) {
              break label313;
            }
            if (QLog.isColorLevel()) {
              QLog.d("[@]", 2, "StructMsgItemCover createView ,url = " + paramContext);
            }
            ((PAHighLightImageView)localObject1).setImageDrawable(paramBundle);
            ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (!bool1) {
              break label299;
            }
            ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe2"));
            label197:
            if ((this.c != null) && (!this.c.equals("")))
            {
              ((View)localObject2).setClickable(true);
              ((View)localObject2).setOnClickListener(this);
            }
            if (QLog.isColorLevel()) {
              QLog.d("[@]", 2, "StructMsgItemCover createView end!");
            }
            return localObject2;
            bool2 = false;
          }
        }
        catch (OutOfMemoryError paramBundle)
        {
          for (;;)
          {
            paramBundle = null;
            continue;
            localObject2 = new PAHighLightImageView(paramContext);
            ((PAHighLightImageView)localObject2).setId(2131361925);
            ((PAHighLightImageView)localObject2).setContentDescription(((Resources)localObject4).getString(2131433025));
            localObject1 = localObject2;
            continue;
            label299:
            ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe4"));
          }
        }
      }
    }
    label313:
    label1854:
    label1859:
    for (;;)
    {
      label494:
      int m;
      try
      {
        if ((paramContext.startsWith("http://")) || (paramContext.startsWith("https://"))) {
          break label1092;
        }
        boolean bool3 = paramContext.startsWith("http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2));
        if (bool3) {
          break label1092;
        }
        try
        {
          if (!paramContext.startsWith("mqqapi://card")) {
            break label973;
          }
          k = paramContext.lastIndexOf("&uin=");
          if (k != -1) {
            break label620;
          }
          if (QLog.isColorLevel()) {
            QLog.e("StructMsgItemCover", 2, "createView, error: index is -1");
          }
          ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.a());
          return localObject2;
        }
        catch (MalformedURLException paramContext)
        {
          k = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.e("StructMsgItemCover", 2, "createView, error: " + paramContext.getMessage());
        }
        ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.a());
        paramContext = null;
        if ((paramContext == null) || (paramContext.getStatus() != 1)) {
          break label1785;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,set null");
        }
        ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (paramBoolean) {
          ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
        }
        if ((paramContext == null) || (!paramBoolean)) {
          break label1812;
        }
        m = k;
        if (k == 0) {
          m = paramContext.getIntrinsicWidth();
        }
        paramContext.setTag(URLDrawableDecodeHandler.a(m, m, m));
        paramContext.setDecodeHandler(URLDrawableDecodeHandler.g);
        ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
        if (paramContext.getStatus() == 1) {
          break label197;
        }
        paramContext.restartDownload();
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label610;
        }
      }
      label603:
      label610:
      label620:
      Object localObject3;
      if ("StructMsgItemCover createView ,exception  = " + paramContext != null)
      {
        paramContext = paramContext.getMessage();
        QLog.d("StructMsgItemCover", 2, paramContext);
        ((PAHighLightImageView)localObject1).setImageDrawable(paramBundle);
        break label197;
        paramView = paramContext.substring("&uin=".length() + k);
        k = paramView.lastIndexOf("&");
        localObject3 = paramView;
        if (k != -1) {
          localObject3 = paramView.substring(0, k);
        }
        if (localObject2 != null)
        {
          localObject4 = ((View)localObject2).getContext();
          if ((localObject4 instanceof BaseActivity))
          {
            ((PAHighLightImageView)localObject1).e = "";
            QQAppInterface localQQAppInterface = ((BaseActivity)localObject4).app;
            paramView = ImageUtil.a();
            if (paramContext.indexOf("internal_phone") > -1)
            {
              k = paramContext.indexOf("&headtext=");
              paramView = "";
              if (k != -1)
              {
                m = paramContext.indexOf("&", k + 1);
                if (m == -1) {
                  paramView = paramContext.substring("&headtext=".length() + k);
                }
              }
              else
              {
                paramContext = URLDecoder.decode(paramView);
                if (TextUtils.isEmpty(paramContext.trim())) {
                  break label914;
                }
                if (!bool2) {
                  break label875;
                }
                if (!ContactUtils.a(paramContext)) {
                  break label859;
                }
                k = ((Context)localObject4).getResources().getDimensionPixelSize(2131558474);
                ((PAHighLightImageView)localObject1).setTextSize(k);
                ((PAHighLightImageView)localObject1).e = paramContext;
                paramContext = ((Context)localObject4).getResources().getDrawable(2130840189);
              }
            }
            for (;;)
            {
              ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
              return localObject2;
              paramView = paramContext.substring(k + "&headtext=".length(), m);
              break;
              label859:
              k = ((Context)localObject4).getResources().getDimensionPixelSize(2131558475);
              break label806;
              label875:
              if (ContactUtils.a(paramContext))
              {
                k = ((Context)localObject4).getResources().getDimensionPixelSize(2131558470);
                break label806;
              }
              k = ((Context)localObject4).getResources().getDimensionPixelSize(2131558472);
              break label806;
              if (((String)localObject3).startsWith("+"))
              {
                paramContext = FaceDrawable.b(localQQAppInterface, (String)localObject3, (byte)3);
              }
              else
              {
                paramContext = FaceDrawable.a(11, 3);
                continue;
                paramContext = FaceDrawable.a(localQQAppInterface, 1, (String)localObject3, 3, paramView, paramView);
              }
            }
          }
        }
        ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.a());
        return localObject2;
        label973:
        if (paramContext.startsWith("troop_notice"))
        {
          ((PAHighLightImageView)localObject1).setImageResource(2130841459);
          return localObject2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,begin decode");
        }
        paramContext = new File(paramContext).toURL().toString();
        for (;;)
        {
          for (;;)
          {
            label1092:
            try
            {
              if (this.jdField_j_of_type_Int == g)
              {
                m = AIOUtils.a(70.0F, (Resources)localObject4);
                k = m;
              }
            }
            catch (MalformedURLException paramContext) {}
            try
            {
              paramContext = URLDrawable.getDrawable(paramContext, k, k, paramBundle, paramBundle, true);
            }
            catch (MalformedURLException paramContext) {}
          }
          if (this.jdField_j_of_type_Int != h) {
            break label1845;
          }
          m = AIOUtils.a(140.0F, (Resources)localObject4);
          k = m;
          continue;
          localObject3 = null;
          if (paramContext.startsWith("http://p.qlogo.cn/gh/"))
          {
            m = paramContext.lastIndexOf("gh/");
            paramView = paramContext.substring("gh/".length() + m).split("/")[0];
            if (TextUtils.isEmpty(paramView)) {
              break label1854;
            }
            paramContext = ((View)localObject2).getContext();
            if ((paramContext instanceof BaseActivity))
            {
              paramContext = ((BaseActivity)paramContext).app;
              localObject3 = FaceDrawable.a(4, 3);
              ((PAHighLightImageView)localObject1).setImageDrawable(FaceDrawable.a(paramContext, 4, paramView, 3, (Drawable)localObject3, (Drawable)localObject3));
              return localObject2;
            }
            ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.a());
            return localObject2;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_j_of_type_Int == g)
        {
          ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
          k = AIOUtils.a(70.0F, (Resources)localObject4);
          label1229:
          if (!bool1) {
            break label1771;
          }
          ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe2"));
        }
        for (;;)
        {
          paramContext = a(paramContext, k, k, paramBundle, paramBundle, true, true, paramView);
          if (paramContext.getTag() == null) {
            paramContext.setTag(Integer.valueOf(0));
          }
          paramContext.setAutoDownload(true);
          if (paramContext.getStatus() != 2) {
            break label1859;
          }
          paramContext.restartDownload();
          break label1859;
          if ((paramContext.startsWith(ShareActionSheet.b)) || (paramContext.startsWith(ShareActionSheet.c)) || (paramContext.startsWith(ShareActionSheet.d)))
          {
            k = paramContext.lastIndexOf("&uin=");
            paramContext = paramContext.substring("&uin=".length() + k);
            paramView = ((View)localObject2).getContext();
            if ((paramView instanceof BaseActivity))
            {
              ((PAHighLightImageView)localObject1).setImageDrawable(((BaseActivity)paramView).app.b(paramContext));
              return localObject2;
            }
            ((PAHighLightImageView)localObject1).setImageDrawable(ImageUtil.a());
            return localObject2;
          }
          if (paramContext.startsWith("http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2)))
          {
            paramView = new ColorDrawable(0);
            ((PAHighLightImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramContext, paramView, paramView));
            return localObject2;
          }
          if (paramContext.startsWith("http://imgplat.store.qq.com/bqq_qfpic/520520"))
          {
            paramBoolean = true;
            this.jdField_a_of_type_Boolean = true;
            paramView = null;
            break;
          }
          if ((this.v != null) && (this.v.equals("1")))
          {
            paramBoolean = true;
            this.jdField_a_of_type_Boolean = true;
            paramView = null;
            break;
          }
          bool2 = paramContext.startsWith("http://qqpublic.qpic.cn");
          if (bool2)
          {
            for (;;)
            {
              for (;;)
              {
                try
                {
                  if (new URL(paramContext).getQuery() != null)
                  {
                    paramView = "&spec=screen";
                    if (this.jdField_j_of_type_Int == g)
                    {
                      paramView = "&spec=small";
                      new String(paramContext);
                      paramView = paramContext + paramView;
                      paramContext = paramView;
                      paramView = (View)localObject3;
                    }
                  }
                }
                catch (MalformedURLException paramView) {}
                try
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
                  {
                    paramView = (View)localObject3;
                    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
                      paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
                    }
                  }
                }
                catch (MalformedURLException paramView)
                {
                  break label1658;
                }
              }
              if (this.jdField_j_of_type_Int == h)
              {
                paramView = "&spec=middle";
                continue;
                paramView = "?spec=screen";
                if (this.jdField_j_of_type_Int == g) {
                  paramView = "?spec=small";
                } else if (this.jdField_j_of_type_Int == h) {
                  paramView = "?spec=middle";
                }
              }
            }
            label1658:
            throw new IllegalArgumentException("illegal url format: " + paramContext);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.istroop != 1008)) {
            break label1840;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
          break;
          if (this.jdField_j_of_type_Int == h)
          {
            ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
            k = AIOUtils.a(140.0F, (Resources)localObject4);
            break label1229;
          }
          ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
          break label1229;
          label1771:
          ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe4"));
        }
        label1785:
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,set listener");
        }
        ((PAHighLightImageView)localObject1).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        break label494;
        ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
        break label197;
        paramContext = " happens error ";
        break label603;
        break label414;
        break label414;
        paramView = null;
        continue;
        break label1048;
        bool1 = false;
        break;
        paramView = null;
      }
    }
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131361855) {
        return (StructMsgForGeneralShare)paramView.getTag(2131361855);
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
    } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (!this.u.endsWith("gif")));
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
        ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, str, String.valueOf(paramView.msgId), "1", "");
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
    paramAbsShareMsg.mContentCover = this.u;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.u = paramObjectInput.readUTF();
    if (this.jdField_a_of_type_Int <= 3) {}
    do
    {
      do
      {
        return;
        this.c = paramObjectInput.readUTF();
        this.b = paramObjectInput.readUTF();
      } while (this.jdField_a_of_type_Int <= 5);
      this.jdField_j_of_type_JavaLangString = paramObjectInput.readUTF();
      this.k = paramObjectInput.readUTF();
      this.l = paramObjectInput.readUTF();
      this.e = paramObjectInput.readInt();
      this.f = paramObjectInput.readInt();
    } while (this.jdField_a_of_type_Int <= 8);
    this.v = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.u == null)
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
        str = this.u;
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
      if (this.jdField_j_of_type_JavaLangString != null) {
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
      paramObjectOutput.writeInt(this.e);
      paramObjectOutput.writeInt(this.f);
    } while (this.jdField_a_of_type_Int <= 8);
    label131:
    if (this.v == null) {}
    for (String str = "";; str = this.v)
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
      str = this.jdField_j_of_type_JavaLangString;
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
    if (this.u == null) {}
    for (String str = "";; str = this.u)
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
          if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
            paramXmlSerializer.attribute(null, "index", this.jdField_j_of_type_JavaLangString);
          }
          if (!TextUtils.isEmpty(this.k)) {
            paramXmlSerializer.attribute(null, "index_name", this.k);
          }
          if (!TextUtils.isEmpty(this.l)) {
            paramXmlSerializer.attribute(null, "index_type", this.l);
          }
          paramXmlSerializer.attribute(null, "w", String.valueOf(this.e));
          paramXmlSerializer.attribute(null, "h", String.valueOf(this.f));
          if ((this.jdField_a_of_type_Int > 8) && (!TextUtils.isEmpty(this.v))) {
            paramXmlSerializer.attribute(null, "needRoundView", this.v);
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
        this.u = str;
      } while (this.jdField_a_of_type_Int <= 3);
      this.c = paramStructMsgNode.a("action");
      this.b = paramStructMsgNode.a("url");
    } while (this.jdField_a_of_type_Int <= 5);
    this.jdField_j_of_type_JavaLangString = paramStructMsgNode.a("index");
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
        k = 0;
        this.e = k;
        str = paramStructMsgNode.a("h");
        if (str != null) {
          continue;
        }
        k = 0;
        this.f = k;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int k;
        this.e = 0;
        this.f = 0;
        continue;
      }
      if (this.jdField_a_of_type_Int <= 8) {
        break;
      }
      this.v = paramStructMsgNode.a("needRoundView");
      return true;
      str = "";
      break label18;
      k = Integer.parseInt(str);
      continue;
      k = Integer.parseInt(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemCover
 * JD-Core Version:    0.7.0.1
 */