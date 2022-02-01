package com.tencent.mobileqq.ocr.data;

import android.text.TextUtils;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.OcrItem;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrDetail;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ARCloudOcrResult
{
  public ARCloudOcrResult.YoutuOcrResult a;
  
  public static ARCloudOcrResult.YoutuOcrResult a(YoutuOcr.YoutuOcrRsp paramYoutuOcrRsp)
  {
    ARCloudOcrResult.YoutuOcrResult localYoutuOcrResult = new ARCloudOcrResult.YoutuOcrResult();
    int i;
    if (paramYoutuOcrRsp.youtu_ocr_errorcode.has()) {
      i = paramYoutuOcrRsp.youtu_ocr_errorcode.get();
    } else {
      i = 0;
    }
    localYoutuOcrResult.jdField_a_of_type_Int = i;
    boolean bool = paramYoutuOcrRsp.youtu_ocr_errormsg.has();
    String str = "";
    Object localObject;
    if (bool) {
      localObject = paramYoutuOcrRsp.youtu_ocr_errormsg.get();
    } else {
      localObject = "";
    }
    localYoutuOcrResult.jdField_a_of_type_JavaLangString = ((String)localObject);
    if (paramYoutuOcrRsp.youtu_orc_detail.has())
    {
      localObject = (YoutuOcr.YoutuOcrDetail)paramYoutuOcrRsp.youtu_orc_detail.get();
      if (((YoutuOcr.YoutuOcrDetail)localObject).errorcode.has()) {
        i = ((YoutuOcr.YoutuOcrDetail)localObject).errorcode.get();
      } else {
        i = -1;
      }
      localYoutuOcrResult.jdField_b_of_type_Int = i;
      paramYoutuOcrRsp = str;
      if (((YoutuOcr.YoutuOcrDetail)localObject).errormsg.has()) {
        paramYoutuOcrRsp = ((YoutuOcr.YoutuOcrDetail)localObject).errormsg.get();
      }
      localYoutuOcrResult.jdField_b_of_type_JavaLangString = paramYoutuOcrRsp;
      if (((YoutuOcr.YoutuOcrDetail)localObject).language.has()) {
        localYoutuOcrResult.e = ((YoutuOcr.YoutuOcrDetail)localObject).language.get();
      }
      if (((YoutuOcr.YoutuOcrDetail)localObject).ocr_language_list.has())
      {
        localYoutuOcrResult.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localYoutuOcrResult.jdField_a_of_type_JavaUtilArrayList.addAll(((YoutuOcr.YoutuOcrDetail)localObject).ocr_language_list.get());
      }
      if (((YoutuOcr.YoutuOcrDetail)localObject).ocr_item.has()) {
        paramYoutuOcrRsp = ((YoutuOcr.YoutuOcrDetail)localObject).ocr_item.get();
      } else {
        paramYoutuOcrRsp = null;
      }
      if (paramYoutuOcrRsp != null) {
        localYoutuOcrResult.d = a(paramYoutuOcrRsp);
      }
    }
    return localYoutuOcrResult;
  }
  
  private static String a(List<YoutuOcr.OcrItem> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = ((YoutuOcr.OcrItem)paramList.next()).itemstring.get();
        if (!TextUtils.isEmpty(str))
        {
          localStringBuilder.append(str);
          localStringBuilder.append("\n");
        }
      }
      return localStringBuilder.toString();
    }
    QLog.d("Q.ocr", 1, "typeSetting regoc items is null");
    return null;
  }
  
  public OcrRecogResult a()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((ARCloudOcrResult.YoutuOcrResult)localObject1).d)))
    {
      localObject1 = new OcrRecogResult();
      Object localObject2 = this.a;
      if (localObject2 != null)
      {
        ((OcrRecogResult)localObject1).language = ((ARCloudOcrResult.YoutuOcrResult)localObject2).e;
        ((OcrRecogResult)localObject1).ocrContent = this.a.d;
        ((OcrRecogResult)localObject1).ocr_languages = this.a.jdField_a_of_type_JavaUtilArrayList;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getUIData ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("Q.ocr", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mOcrResult:");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.ARCloudOcrResult
 * JD-Core Version:    0.7.0.1
 */