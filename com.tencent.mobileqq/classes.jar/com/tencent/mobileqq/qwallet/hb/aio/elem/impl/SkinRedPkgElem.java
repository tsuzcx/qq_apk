package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.util.HashMap;

public class SkinRedPkgElem
  extends BaseRedPkgElem
{
  public static String[] a;
  public int a;
  public Bitmap a;
  public AnimationView.AnimationInfo a;
  public HashMap<String, Bitmap> a;
  public String b;
  public String c;
  public String d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "icon_def", "icon_txt", "icon_voice", "icon_video", "icon_sp" };
  }
  
  public SkinRedPkgElem(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public Bitmap a(RedPacketInfo paramRedPacketInfo)
  {
    Object localObject = null;
    if (paramRedPacketInfo == null) {
      return null;
    }
    String str = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).MessageForQQWalletMsg$icon_name(paramRedPacketInfo);
    paramRedPacketInfo = (RedPacketInfo)localObject;
    if (str != null) {
      paramRedPacketInfo = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    }
    localObject = paramRedPacketInfo;
    if (paramRedPacketInfo == null) {
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get("icon_def");
    }
    return localObject;
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.b = paramRedPacketInfo.background;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramRedPacketInfo.corner;
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = paramRedPacketInfo.animInfo;
      this.c = paramRedPacketInfo.title;
      this.jdField_a_of_type_Int = paramRedPacketInfo.isHideTitle;
      this.d = paramRedPacketInfo.resPath;
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramRedPacketInfo.attribute.containsKey(str))
        {
          Bitmap localBitmap = (Bitmap)paramRedPacketInfo.attribute.getParcelable(str);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localBitmap);
        }
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return (this.b != null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.SkinRedPkgElem
 * JD-Core Version:    0.7.0.1
 */