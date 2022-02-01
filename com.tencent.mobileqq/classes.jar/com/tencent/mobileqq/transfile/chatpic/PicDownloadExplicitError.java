package com.tencent.mobileqq.transfile.chatpic;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import anlk;
import annq;
import ayxy;
import bdzn;
import bdzu;
import bdzx;
import beal;
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
  private static final Map<Integer, beal> a = new HashMap();
  private int mErrCode;
  
  static
  {
    a.put(Integer.valueOf(1), new beal(2130838061, 2131689913));
    a.put(Integer.valueOf(2), new beal(-1, 2131689914));
    a.put(Integer.valueOf(3), new beal(-1, 2131689915));
  }
  
  private PicDownloadExplicitError(int paramInt)
  {
    this.mErrCode = paramInt;
  }
  
  private static PicDownloadExplicitError a(ayxy paramayxy)
  {
    return null;
  }
  
  private static PicDownloadExplicitError a(bdzu parambdzu)
  {
    Object localObject = parambdzu.jdField_a_of_type_Bdzn;
    long l;
    String str;
    if (localObject != null)
    {
      l = parambdzu.jdField_a_of_type_Long;
      str = parambdzu.jdField_a_of_type_JavaLangString;
      int i = ((bdzn)localObject).jdField_a_of_type_Int;
      localObject = ((bdzn)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if ((annq.a((MessageRecord)localObject)) || (anlk.a((MessageRecord)localObject))) {
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
          parambdzu = new PicDownloadExplicitError(1);
        }
      }
    }
    for (;;)
    {
      return parambdzu;
      if (parambdzu.jdField_a_of_type_Long == 9302L)
      {
        parambdzu = new PicDownloadExplicitError(2);
      }
      else
      {
        if ((l == 9039L) || (l == 9040L))
        {
          parambdzu = new PicDownloadExplicitError(3);
          continue;
          if (l == -9527L)
          {
            if ("T_208".equals(str)) {
              parambdzu = new PicDownloadExplicitError(1);
            }
          }
          else
          {
            if (parambdzu.jdField_a_of_type_Long == 9302L)
            {
              parambdzu = new PicDownloadExplicitError(2);
              continue;
            }
            if ((l == 9039L) || (l == 9040L))
            {
              parambdzu = new PicDownloadExplicitError(3);
              continue;
            }
          }
        }
        label311:
        parambdzu = null;
      }
    }
  }
  
  private String a()
  {
    beal localbeal = (beal)a.get(Integer.valueOf(this.mErrCode));
    if (localbeal != null)
    {
      int i = localbeal.b();
      if (i > 0) {
        return BaseApplicationImpl.getApplication().getResources().getString(i);
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131689913);
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
    if ((paramObject instanceof bdzu)) {
      return a((bdzu)paramObject);
    }
    if ((paramObject instanceof ayxy)) {
      return a((ayxy)paramObject);
    }
    return null;
  }
  
  public Drawable getFailedDrawable()
  {
    beal localbeal = (beal)a.get(Integer.valueOf(this.mErrCode));
    if (localbeal != null)
    {
      int i = localbeal.a();
      if (i > 0) {
        return bdzx.a(i);
      }
    }
    return bdzx.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError
 * JD-Core Version:    0.7.0.1
 */