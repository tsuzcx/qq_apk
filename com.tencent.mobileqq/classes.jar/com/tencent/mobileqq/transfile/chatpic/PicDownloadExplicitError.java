package com.tencent.mobileqq.transfile.chatpic;

import ajwd;
import ajyk;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import aunu;
import aywa;
import aywh;
import aywk;
import aywz;
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
  private static final Map<Integer, aywz> a = new HashMap();
  private int mErrCode;
  
  static
  {
    a.put(Integer.valueOf(1), new aywz(2130837910, 2131689976));
    a.put(Integer.valueOf(2), new aywz(-1, 2131689977));
    a.put(Integer.valueOf(3), new aywz(-1, 2131689978));
  }
  
  private PicDownloadExplicitError(int paramInt)
  {
    this.mErrCode = paramInt;
  }
  
  private static PicDownloadExplicitError a(aunu paramaunu)
  {
    return null;
  }
  
  private static PicDownloadExplicitError a(aywh paramaywh)
  {
    Object localObject = paramaywh.jdField_a_of_type_Aywa;
    long l;
    String str;
    if (localObject != null)
    {
      l = paramaywh.jdField_a_of_type_Long;
      str = paramaywh.jdField_a_of_type_JavaLangString;
      int i = ((aywa)localObject).jdField_a_of_type_Int;
      localObject = ((aywa)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if ((ajyk.a((MessageRecord)localObject)) || (ajwd.a((MessageRecord)localObject))) {
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
          paramaywh = new PicDownloadExplicitError(1);
        }
      }
    }
    for (;;)
    {
      return paramaywh;
      if (paramaywh.jdField_a_of_type_Long == 9302L)
      {
        paramaywh = new PicDownloadExplicitError(2);
      }
      else
      {
        if ((l == 9039L) || (l == 9040L))
        {
          paramaywh = new PicDownloadExplicitError(3);
          continue;
          if (l == -9527L)
          {
            if ("T_208".equals(str)) {
              paramaywh = new PicDownloadExplicitError(1);
            }
          }
          else
          {
            if (paramaywh.jdField_a_of_type_Long == 9302L)
            {
              paramaywh = new PicDownloadExplicitError(2);
              continue;
            }
            if ((l == 9039L) || (l == 9040L))
            {
              paramaywh = new PicDownloadExplicitError(3);
              continue;
            }
          }
        }
        label311:
        paramaywh = null;
      }
    }
  }
  
  private String a()
  {
    aywz localaywz = (aywz)a.get(Integer.valueOf(this.mErrCode));
    if (localaywz != null)
    {
      int i = localaywz.b();
      if (i > 0) {
        return BaseApplicationImpl.getApplication().getResources().getString(i);
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131689976);
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
    if ((paramObject instanceof aywh)) {
      return a((aywh)paramObject);
    }
    if ((paramObject instanceof aunu)) {
      return a((aunu)paramObject);
    }
    return null;
  }
  
  public Drawable getFailedDrawable()
  {
    aywz localaywz = (aywz)a.get(Integer.valueOf(this.mErrCode));
    if (localaywz != null)
    {
      int i = localaywz.a();
      if (i > 0) {
        return aywk.a(i);
      }
    }
    return aywk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError
 * JD-Core Version:    0.7.0.1
 */