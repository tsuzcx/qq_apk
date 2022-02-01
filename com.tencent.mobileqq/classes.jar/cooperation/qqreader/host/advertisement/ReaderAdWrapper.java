package cooperation.qqreader.host.advertisement;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.PackageUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo;

public class ReaderAdWrapper
{
  public static final int PRODUCT_TYPE_APP = 12;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private ReaderAdWrapper.ImageData jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderAdWrapper$ImageData;
  private ReaderAdWrapper jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderAdWrapper;
  private String jdField_a_of_type_JavaLangString;
  private List<ReaderAdWrapper.ImageData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long = -1L;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  
  ReaderAdWrapper(GdtAd paramGdtAd, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getAId();
    paramGdtAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getImageData();
    if (paramGdtAd != null)
    {
      this.jdField_b_of_type_JavaLangString = paramGdtAd.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderAdWrapper$ImageData = new ReaderAdWrapper.ImageData(paramGdtAd);
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getVideoUrl();
    this.d = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getText();
    this.f = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForImpression();
    if (!this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.display_info.button_info.get().isEmpty()) {
      this.e = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.display_info.button_info.get(0)).txt.get();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.display_info.muti_pic_text_info.image.size())
    {
      paramGdtAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getImageData(i);
      if ((paramGdtAd != null) && (paramGdtAd.a())) {
        this.jdField_a_of_type_JavaUtilList.add(new ReaderAdWrapper.ImageData(paramGdtAd));
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    this.jdField_b_of_type_Long = new Date().getTime();
  }
  
  GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  }
  
  public long getAId()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ReaderAdWrapper.ImageData getBasicImageData()
  {
    return this.jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderAdWrapper$ImageData;
  }
  
  public String getExposureReportUrl()
  {
    return this.f;
  }
  
  public ReaderAdWrapper getExtraData()
  {
    return this.jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderAdWrapper;
  }
  
  public String getImageUrl()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<ReaderAdWrapper.ImageData> getMultiImageData()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public String getPosId()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String getProcessedBtnTxt()
  {
    if (isAppType())
    {
      if (isAdAppInstalled()) {
        return "立即打开";
      }
      return "立即下载";
    }
    if (TextUtils.isEmpty(this.e)) {
      return "查看详情";
    }
    return this.e;
  }
  
  public String getTxt()
  {
    return this.d;
  }
  
  public int getUsedCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long getVideoStartPos()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String getVideoUrl()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void increaseUsedCount()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public boolean isAdAppInstalled()
  {
    return PackageUtil.a(BaseApplicationImpl.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getAppPackageName());
  }
  
  public boolean isAppType()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getProductType() == 12;
  }
  
  public boolean isDataValid()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null;
  }
  
  public boolean isExpired()
  {
    return new Date().getTime() - this.jdField_b_of_type_Long > 3600000L;
  }
  
  public boolean isLocalBook()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean isVideoAd()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void setExtraData(ReaderAdWrapper paramReaderAdWrapper)
  {
    this.jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderAdWrapper = paramReaderAdWrapper;
  }
  
  public void setLocalBook(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setVideoStartPos(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderAdWrapper
 * JD-Core Version:    0.7.0.1
 */