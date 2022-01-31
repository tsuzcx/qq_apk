package com.tencent.mobileqq.transfile.chatpic;

import ajwb;
import ajyi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import aunw;
import aywc;
import aywj;
import aywm;
import ayxb;
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
  private static final Map<Integer, ayxb> a = new HashMap();
  private int mErrCode;
  
  static
  {
    a.put(Integer.valueOf(1), new ayxb(2130837910, 2131689976));
    a.put(Integer.valueOf(2), new ayxb(-1, 2131689977));
    a.put(Integer.valueOf(3), new ayxb(-1, 2131689978));
  }
  
  private PicDownloadExplicitError(int paramInt)
  {
    this.mErrCode = paramInt;
  }
  
  private static PicDownloadExplicitError a(aunw paramaunw)
  {
    return null;
  }
  
  private static PicDownloadExplicitError a(aywj paramaywj)
  {
    Object localObject = paramaywj.jdField_a_of_type_Aywc;
    long l;
    String str;
    if (localObject != null)
    {
      l = paramaywj.jdField_a_of_type_Long;
      str = paramaywj.jdField_a_of_type_JavaLangString;
      int i = ((aywc)localObject).jdField_a_of_type_Int;
      localObject = ((aywc)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if ((ajyi.a((MessageRecord)localObject)) || (ajwb.a((MessageRecord)localObject))) {
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
          paramaywj = new PicDownloadExplicitError(1);
        }
      }
    }
    for (;;)
    {
      return paramaywj;
      if (paramaywj.jdField_a_of_type_Long == 9302L)
      {
        paramaywj = new PicDownloadExplicitError(2);
      }
      else
      {
        if ((l == 9039L) || (l == 9040L))
        {
          paramaywj = new PicDownloadExplicitError(3);
          continue;
          if (l == -9527L)
          {
            if ("T_208".equals(str)) {
              paramaywj = new PicDownloadExplicitError(1);
            }
          }
          else
          {
            if (paramaywj.jdField_a_of_type_Long == 9302L)
            {
              paramaywj = new PicDownloadExplicitError(2);
              continue;
            }
            if ((l == 9039L) || (l == 9040L))
            {
              paramaywj = new PicDownloadExplicitError(3);
              continue;
            }
          }
        }
        label311:
        paramaywj = null;
      }
    }
  }
  
  private String a()
  {
    ayxb localayxb = (ayxb)a.get(Integer.valueOf(this.mErrCode));
    if (localayxb != null)
    {
      int i = localayxb.b();
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
    if ((paramObject instanceof aywj)) {
      return a((aywj)paramObject);
    }
    if ((paramObject instanceof aunw)) {
      return a((aunw)paramObject);
    }
    return null;
  }
  
  public Drawable getFailedDrawable()
  {
    ayxb localayxb = (ayxb)a.get(Integer.valueOf(this.mErrCode));
    if (localayxb != null)
    {
      int i = localayxb.a();
      if (i > 0) {
        return aywm.a(i);
      }
    }
    return aywm.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError
 * JD-Core Version:    0.7.0.1
 */