package com.tencent.mobileqq.medalwall;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneShareManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ShareHelper
{
  public static final String k = HardCodeUtil.a(2131911358);
  ShareActionSheetBuilder a = null;
  Context b;
  QQAppInterface c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public Bitmap i;
  public String j = "";
  
  public ShareHelper(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.b = paramContext;
    this.c = paramQQAppInterface;
  }
  
  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Canvas localCanvas = null;
    if (paramDrawable == null) {
      return null;
    }
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    try
    {
      if ((paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0)) {
        localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      } else {
        localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject = localCanvas;
      if (QLog.isColorLevel())
      {
        QLog.i("ShareHelper", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        localObject = localCanvas;
      }
    }
    if (localObject != null)
    {
      localCanvas = new Canvas((Bitmap)localObject);
      Rect localRect = paramDrawable.copyBounds();
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      paramDrawable.setBounds(localRect);
    }
    return localObject;
  }
  
  public static String a(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    return new SimpleDateFormat("yyyyMMdd").format(paramLong);
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder1 = new StringBuilder(Base64.encodeToString(paramString.getBytes(), 3).replace("=", ""));
    char c1 = localStringBuilder1.charAt(0);
    localStringBuilder1.deleteCharAt(0);
    localStringBuilder1.append(c1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("encodeOne src:");
      localStringBuilder2.append(Base64.encodeToString(paramString.getBytes(), 0));
      localStringBuilder2.append(" dst:");
      localStringBuilder2.append(localStringBuilder1.toString());
      QLog.i("ShareHelper", 4, localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
  
  public static String a(String[] paramArrayOfString)
  {
    int m = 0;
    while (m < paramArrayOfString.length)
    {
      paramArrayOfString[m] = a(paramArrayOfString[m]);
      m += 1;
    }
    return b(paramArrayOfString);
  }
  
  private boolean a()
  {
    return (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.h));
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894171);
    localActionSheetItem.icon = 2130839221;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894185);
    localActionSheetItem.icon = 2130839222;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894174);
    localActionSheetItem.icon = 2130839219;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private static String b(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int n = 0;
    int i1;
    for (int m = 0; n < paramArrayOfString.length; m = i1)
    {
      i1 = m;
      if (paramArrayOfString[n].length() > m) {
        i1 = paramArrayOfString[n].length();
      }
      n += 1;
    }
    n = 0;
    while (n < m)
    {
      i1 = 0;
      while (i1 < paramArrayOfString.length)
      {
        if (paramArrayOfString[i1].length() > n) {
          localStringBuilder.append(paramArrayOfString[i1].charAt(n));
        }
        i1 += 1;
      }
      n += 1;
    }
    return a(localStringBuilder.toString());
  }
  
  private void b()
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(114).a(this.e).e(this.d).a();
    localAbsShareMsg.mSourceName = this.h;
    localAbsShareMsg.mSourceAction = "web";
    localAbsShareMsg.mSourceUrl = this.j;
    Object localObject = StructMsgElementFactory.a(2);
    ((AbsStructMsgItem)localObject).a(this.g, this.e, this.f);
    localAbsShareMsg.addItem((AbsStructMsgElement)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("forward_type", -3);
    ((Intent)localObject).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
    ((Intent)localObject).putExtra("forwardDirect", true);
    ForwardBaseOption.a((Activity)this.b, (Intent)localObject, 21);
  }
  
  private void c()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.g)) {
      localArrayList.add(this.g);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.e);
    localBundle.putString("desc", this.f);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", this.d);
    localBundle.putString("url", this.d);
    localBundle.putStringArrayList("image_url", localArrayList);
    QZoneShareManager.jumpToQzoneShare(this.c, this.b, localBundle, null);
  }
  
  private void d()
  {
    long l = System.currentTimeMillis();
    WXShareHelper.a().d(String.valueOf(l), this.e, this.i, this.f, this.d);
  }
  
  private void e()
  {
    long l = System.currentTimeMillis();
    WXShareHelper.a().c(String.valueOf(l), this.e, this.i, this.f, this.d);
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!a())
    {
      QQToast.makeText(this.b, HardCodeUtil.a(2131911359), 0).show();
      return;
    }
    Object localObject;
    if (this.a == null)
    {
      localObject = new ShareHelper.1(this);
      paramOnDismissListener = new ShareHelper.2(this, paramOnDismissListener);
      this.a = new ShareActionSheetBuilder((Activity)this.b);
      this.a.setActionSheetTitle(this.b.getString(2131916565));
      this.a.setActionSheetItems(a(this.b));
      this.a.setItemClickListener((AdapterView.OnItemClickListener)localObject);
      this.a.setOnDismissListener(paramOnDismissListener);
    }
    try
    {
      if (!this.a.getActionSheet().isShowing())
      {
        this.a.show();
        return;
      }
    }
    catch (Exception paramOnDismissListener)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("actionSheet.show exception=");
        ((StringBuilder)localObject).append(paramOnDismissListener);
        QLog.d("ShareActionSheet", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap)
  {
    this.d = paramString3;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString4;
    this.h = paramString5;
    this.i = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.ShareHelper
 * JD-Core Version:    0.7.0.1
 */