package com.tencent.mobileqq.ocr.data;

import android.text.TextUtils;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchDetail;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchRsp;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSkuItem;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.OcrItem;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrDetail;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ARCloudOcrResult
{
  public ARCloudOcrResult.JDSearchResult a;
  public ARCloudOcrResult.YoutuOcrResult a;
  
  public static ARCloudOcrResult.JDSearchResult a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    int j = -1;
    ARCloudOcrResult.JDSearchResult localJDSearchResult = new ARCloudOcrResult.JDSearchResult();
    int i;
    Object localObject;
    label262:
    if (paramJdSearchRsp.jd_search_errorcode.has())
    {
      i = paramJdSearchRsp.jd_search_errorcode.get();
      localJDSearchResult.jdField_a_of_type_Int = i;
      if (!paramJdSearchRsp.jd_search_errormsg.has()) {
        break label324;
      }
      localObject = paramJdSearchRsp.jd_search_errormsg.get();
      label53:
      localJDSearchResult.jdField_a_of_type_JavaLangString = ((String)localObject);
      label148:
      label286:
      if (paramJdSearchRsp.jd_search_detail.has())
      {
        localObject = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
        i = j;
        if (((JDSearch.JdSearchDetail)localObject).errorcode.has()) {
          i = ((JDSearch.JdSearchDetail)localObject).errorcode.get();
        }
        localJDSearchResult.jdField_b_of_type_Int = i;
        if (!((JDSearch.JdSearchDetail)localObject).errormsg.has()) {
          break label330;
        }
        paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject).errormsg.get();
        label124:
        localJDSearchResult.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
        if (!((JDSearch.JdSearchDetail)localObject).jd_more_url.has()) {
          break label336;
        }
        paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject).jd_more_url.get();
        localJDSearchResult.i = paramJdSearchRsp;
        if (!((JDSearch.JdSearchDetail)localObject).jd_sku_item.has()) {
          break label342;
        }
        paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject).jd_sku_item.get();
        label172:
        if ((paramJdSearchRsp != null) && (paramJdSearchRsp.size() > 0))
        {
          localObject = (JDSearch.JdSkuItem)paramJdSearchRsp.get(0);
          if (!((JDSearch.JdSkuItem)localObject).detail_url.has()) {
            break label347;
          }
          paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject).detail_url.get();
          label214:
          localJDSearchResult.d = paramJdSearchRsp;
          if (!((JDSearch.JdSkuItem)localObject).image_url.has()) {
            break label353;
          }
          paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject).image_url.get();
          label238:
          localJDSearchResult.e = paramJdSearchRsp;
          if (!((JDSearch.JdSkuItem)localObject).sku_id.has()) {
            break label359;
          }
          paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject).sku_id.get();
          localJDSearchResult.f = paramJdSearchRsp;
          if (!((JDSearch.JdSkuItem)localObject).sku_name.has()) {
            break label365;
          }
          paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject).sku_name.get();
          localJDSearchResult.g = paramJdSearchRsp;
          if (!((JDSearch.JdSkuItem)localObject).sku_price.has()) {
            break label371;
          }
        }
      }
    }
    label324:
    label330:
    label336:
    label342:
    label347:
    label353:
    label359:
    label365:
    label371:
    for (paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject).sku_price.get();; paramJdSearchRsp = "")
    {
      localJDSearchResult.h = paramJdSearchRsp;
      return localJDSearchResult;
      i = -1;
      break;
      localObject = "";
      break label53;
      paramJdSearchRsp = "";
      break label124;
      paramJdSearchRsp = "";
      break label148;
      paramJdSearchRsp = null;
      break label172;
      paramJdSearchRsp = "";
      break label214;
      paramJdSearchRsp = "";
      break label238;
      paramJdSearchRsp = "";
      break label262;
      paramJdSearchRsp = "";
      break label286;
    }
  }
  
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
        break label158;
      }
      localObject = paramYoutuOcrRsp.youtu_ocr_errormsg.get();
      label49:
      localYoutuOcrResult.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (paramYoutuOcrRsp.youtu_orc_detail.has())
      {
        localObject = (YoutuOcr.YoutuOcrDetail)paramYoutuOcrRsp.youtu_orc_detail.get();
        if (!((YoutuOcr.YoutuOcrDetail)localObject).errorcode.has()) {
          break label164;
        }
        i = ((YoutuOcr.YoutuOcrDetail)localObject).errorcode.get();
        label93:
        localYoutuOcrResult.jdField_b_of_type_Int = i;
        if (!((YoutuOcr.YoutuOcrDetail)localObject).errormsg.has()) {
          break label169;
        }
        paramYoutuOcrRsp = ((YoutuOcr.YoutuOcrDetail)localObject).errormsg.get();
        label116:
        localYoutuOcrResult.jdField_b_of_type_JavaLangString = paramYoutuOcrRsp;
        if (!((YoutuOcr.YoutuOcrDetail)localObject).ocr_item.has()) {
          break label175;
        }
      }
    }
    label158:
    label164:
    label169:
    label175:
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
  
  private static String a(List paramList)
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
    String str = null;
    if (((this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$YoutuOcrResult == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$YoutuOcrResult.d))) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult == null)) {
      return null;
    }
    OcrRecogResult localOcrRecogResult = new OcrRecogResult();
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$YoutuOcrResult != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$YoutuOcrResult.d;
    }
    localOcrRecogResult.ocrContent = str;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult != null)
    {
      localOcrRecogResult.goodsName = this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult.g;
      localOcrRecogResult.goodsDetailUrl = this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult.d;
      localOcrRecogResult.goodsPicUrl = this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult.e;
    }
    try
    {
      localOcrRecogResult.goodsPrice = Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult.h).floatValue();
      localOcrRecogResult.moreUrl = this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult.i;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr", 2, "getUIData " + localOcrRecogResult);
      }
      return localOcrRecogResult;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localOcrRecogResult.goodsPrice = 0.0F;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mOcrResult:").append(this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$YoutuOcrResult).append("\n").append(",mJdResult:").append(this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.ARCloudOcrResult
 * JD-Core Version:    0.7.0.1
 */