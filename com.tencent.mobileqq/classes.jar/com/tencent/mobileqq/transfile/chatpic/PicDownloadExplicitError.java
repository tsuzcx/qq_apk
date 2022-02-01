package com.tencent.mobileqq.transfile.chatpic;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import anxg;
import anzr;
import azql;
import beyg;
import beyn;
import beyq;
import beze;
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
  private static final Map<Integer, beze> a = new HashMap();
  private int mErrCode;
  
  static
  {
    a.put(Integer.valueOf(1), new beze(2130838071, 2131689920));
    a.put(Integer.valueOf(2), new beze(-1, 2131689921));
    a.put(Integer.valueOf(3), new beze(-1, 2131689922));
  }
  
  private PicDownloadExplicitError(int paramInt)
  {
    this.mErrCode = paramInt;
  }
  
  private static PicDownloadExplicitError a(azql paramazql)
  {
    return null;
  }
  
  private static PicDownloadExplicitError a(beyn parambeyn)
  {
    Object localObject = parambeyn.jdField_a_of_type_Beyg;
    long l;
    String str;
    if (localObject != null)
    {
      l = parambeyn.jdField_a_of_type_Long;
      str = parambeyn.jdField_a_of_type_JavaLangString;
      int i = ((beyg)localObject).jdField_a_of_type_Int;
      localObject = ((beyg)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if ((anzr.a((MessageRecord)localObject)) || (anxg.a((MessageRecord)localObject))) {
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
          parambeyn = new PicDownloadExplicitError(1);
        }
      }
    }
    for (;;)
    {
      return parambeyn;
      if (parambeyn.jdField_a_of_type_Long == 9302L)
      {
        parambeyn = new PicDownloadExplicitError(2);
      }
      else
      {
        if ((l == 9039L) || (l == 9040L))
        {
          parambeyn = new PicDownloadExplicitError(3);
          continue;
          if (l == -9527L)
          {
            if ("T_208".equals(str)) {
              parambeyn = new PicDownloadExplicitError(1);
            }
          }
          else
          {
            if (parambeyn.jdField_a_of_type_Long == 9302L)
            {
              parambeyn = new PicDownloadExplicitError(2);
              continue;
            }
            if ((l == 9039L) || (l == 9040L))
            {
              parambeyn = new PicDownloadExplicitError(3);
              continue;
            }
          }
        }
        label311:
        parambeyn = null;
      }
    }
  }
  
  private String a()
  {
    beze localbeze = (beze)a.get(Integer.valueOf(this.mErrCode));
    if (localbeze != null)
    {
      int i = localbeze.b();
      if (i > 0) {
        return BaseApplicationImpl.getApplication().getResources().getString(i);
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131689920);
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
    if ((paramObject instanceof beyn)) {
      return a((beyn)paramObject);
    }
    if ((paramObject instanceof azql)) {
      return a((azql)paramObject);
    }
    return null;
  }
  
  public Drawable getFailedDrawable()
  {
    beze localbeze = (beze)a.get(Integer.valueOf(this.mErrCode));
    if (localbeze != null)
    {
      int i = localbeze.a();
      if (i > 0) {
        return beyq.a(i);
      }
    }
    return beyq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError
 * JD-Core Version:    0.7.0.1
 */