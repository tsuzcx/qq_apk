package com.tencent.mobileqq.transfile.chatpic;

import ajhz;
import ajke;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import atpw;
import axvt;
import axwa;
import axwd;
import axws;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.CustomError;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class PicDownloadExplicitError
  extends CustomError
{
  public static final String C2C_PIC_REQUEST_EXPIRED_DESC = "T_208";
  public static final String GROUP_PIC_EXPIRED_DESC = "H_404_-6101";
  public static final String GROUP_PIC_REQUEST_EXPIRED_DESC = "T_203";
  public static final String GROUP_PIC_REQUEST_QUERY_INDEX_TIMEOUT_DESC = "T_206";
  public static final String TAG = "PicDownloadExplicitError";
  private static final Map<Integer, axws> a = new HashMap();
  private int mErrCode;
  private String mErrorDesc;
  private int mOriginCode;
  
  static
  {
    a.put(Integer.valueOf(1), new axws(2130837833, 2131624424));
    a.put(Integer.valueOf(2), new axws(-1, 2131624425));
    a.put(Integer.valueOf(3), new axws(-1, 2131624426));
  }
  
  private PicDownloadExplicitError(int paramInt)
  {
    this.mErrCode = paramInt;
  }
  
  private static PicDownloadExplicitError a(atpw paramatpw)
  {
    return null;
  }
  
  private static PicDownloadExplicitError a(axwa paramaxwa)
  {
    Object localObject = paramaxwa.jdField_a_of_type_Axvt;
    long l;
    String str;
    if (localObject != null)
    {
      l = paramaxwa.jdField_a_of_type_Long;
      str = paramaxwa.jdField_a_of_type_JavaLangString;
      int i = ((axvt)localObject).jdField_a_of_type_Int;
      localObject = ((axvt)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if ((ajke.a((MessageRecord)localObject)) || (ajhz.a((MessageRecord)localObject))) {
          return null;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicDownloadExplicitError", 2, "getError,errCode:" + l + " errDesc:" + str + " uinType:" + i);
      }
      if ((i == 1) || (i == 3000)) {
        if (l == -9527L)
        {
          if ((!"H_404_-6101".equals(str)) && (!"T_203".equals(str)) && (!"T_206".equals(str))) {
            break label311;
          }
          paramaxwa = new PicDownloadExplicitError(1);
        }
      }
    }
    for (;;)
    {
      return paramaxwa;
      if (paramaxwa.jdField_a_of_type_Long == 9302L)
      {
        paramaxwa = new PicDownloadExplicitError(2);
      }
      else
      {
        if ((l == 9039L) || (l == 9040L))
        {
          paramaxwa = new PicDownloadExplicitError(3);
          continue;
          if (l == -9527L)
          {
            if ("T_208".equals(str)) {
              paramaxwa = new PicDownloadExplicitError(1);
            }
          }
          else
          {
            if (paramaxwa.jdField_a_of_type_Long == 9302L)
            {
              paramaxwa = new PicDownloadExplicitError(2);
              continue;
            }
            if ((l == 9039L) || (l == 9040L))
            {
              paramaxwa = new PicDownloadExplicitError(3);
              continue;
            }
          }
        }
        label311:
        paramaxwa = null;
      }
    }
  }
  
  private String a()
  {
    axws localaxws = (axws)a.get(Integer.valueOf(this.mErrCode));
    if (localaxws != null)
    {
      int i = localaxws.b();
      if (i > 0) {
        return BaseApplicationImpl.getApplication().getResources().getString(i);
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131624424);
  }
  
  public static String getFailedTip(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStateError() instanceof PicDownloadExplicitError)) {
      return ((PicDownloadExplicitError)paramURLDrawable.getStateError()).a();
    }
    return null;
  }
  
  public static PicDownloadExplicitError getPicError(Object paramObject)
  {
    if ((paramObject instanceof axwa)) {
      return a((axwa)paramObject);
    }
    if ((paramObject instanceof atpw)) {
      return a((atpw)paramObject);
    }
    return null;
  }
  
  public Drawable getFailedDrawable()
  {
    axws localaxws = (axws)a.get(Integer.valueOf(this.mErrCode));
    if (localaxws != null)
    {
      int i = localaxws.a();
      if (i > 0) {
        return axwd.a(i);
      }
    }
    return axwd.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError
 * JD-Core Version:    0.7.0.1
 */