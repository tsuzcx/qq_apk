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
    Object localObject;
    if (paramYoutuOcrRsp.youtu_ocr_errorcode.has())
    {
      i = paramYoutuOcrRsp.youtu_ocr_errorcode.get();
      localYoutuOcrResult.jdField_a_of_type_Int = i;
      if (!paramYoutuOcrRsp.youtu_ocr_errormsg.has()) {
        break label215;
      }
      localObject = paramYoutuOcrRsp.youtu_ocr_errormsg.get();
      label49:
      localYoutuOcrResult.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (paramYoutuOcrRsp.youtu_orc_detail.has())
      {
        localObject = (YoutuOcr.YoutuOcrDetail)paramYoutuOcrRsp.youtu_orc_detail.get();
        if (!((YoutuOcr.YoutuOcrDetail)localObject).errorcode.has()) {
          break label221;
        }
        i = ((YoutuOcr.YoutuOcrDetail)localObject).errorcode.get();
        label93:
        localYoutuOcrResult.jdField_b_of_type_Int = i;
        if (!((YoutuOcr.YoutuOcrDetail)localObject).errormsg.has()) {
          break label226;
        }
        paramYoutuOcrRsp = ((YoutuOcr.YoutuOcrDetail)localObject).errormsg.get();
        label116:
        localYoutuOcrResult.jdField_b_of_type_JavaLangString = paramYoutuOcrRsp;
        if (((YoutuOcr.YoutuOcrDetail)localObject).language.has()) {
          localYoutuOcrResult.e = ((YoutuOcr.YoutuOcrDetail)localObject).language.get();
        }
        if (((YoutuOcr.YoutuOcrDetail)localObject).ocr_language_list.has())
        {
          localYoutuOcrResult.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localYoutuOcrResult.jdField_a_of_type_JavaUtilArrayList.addAll(((YoutuOcr.YoutuOcrDetail)localObject).ocr_language_list.get());
        }
        if (!((YoutuOcr.YoutuOcrDetail)localObject).ocr_item.has()) {
          break label232;
        }
      }
    }
    label215:
    label221:
    label226:
    label232:
    for (paramYoutuOcrRsp = ((YoutuOcr.YoutuOcrDetail)localObject).ocr_item.get();; paramYoutuOcrRsp = null)
    {
      if (paramYoutuOcrRsp != null) {
        localYoutuOcrResult.d = a(paramYoutuOcrRsp);
      }
      return localYoutuOcrResult;
      i = 0;
      break;
      localObject = "";
      break label49;
      i = -1;
      break label93;
      paramYoutuOcrRsp = "";
      break label116;
    }
  }
  
  private static String a(List<YoutuOcr.OcrItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.d("Q.ocr", 1, "typeSetting regoc items is null");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((YoutuOcr.OcrItem)paramList.next()).itemstring.get();
      if (!TextUtils.isEmpty(str)) {
        localStringBuilder.append(str).append("\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public OcrRecogResult a()
  {
    Object localObject;
    if ((this.a == null) || (TextUtils.isEmpty(this.a.d))) {
      localObject = null;
    }
    OcrRecogResult localOcrRecogResult;
    do
    {
      return localObject;
      localOcrRecogResult = new OcrRecogResult();
      if (this.a != null)
      {
        localOcrRecogResult.language = this.a.e;
        localOcrRecogResult.ocrContent = this.a.d;
        localOcrRecogResult.ocr_languages = this.a.jdField_a_of_type_JavaUtilArrayList;
      }
      localObject = localOcrRecogResult;
    } while (!QLog.isColorLevel());
    QLog.d("Q.ocr", 2, "getUIData " + localOcrRecogResult);
    return localOcrRecogResult;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mOcrResult:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.ARCloudOcrResult
 * JD-Core Version:    0.7.0.1
 */