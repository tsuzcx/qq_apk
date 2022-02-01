package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.qphone.base.util.QLog;

public class VideoFeedsShuntBarConfigure
{
  private static final String jdField_a_of_type_JavaLangString = "VideoFeedsShuntBarConfigure";
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SparseIntArray jdField_b_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private String jdField_b_of_type_JavaLangString;
  
  public VideoFeedsShuntBarConfigure(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = RIJQQAppInterfaceUtil.a();
  }
  
  public void a()
  {
    ThreadManagerV2.executeOnSubThread(new VideoFeedsShuntBarConfigure.1(this));
  }
  
  public boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    Object localObject = Integer.valueOf(0);
    if (paramECommerceEntranceInfo == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        boolean bool = ReadInJoyHelper.A(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
          localStringBuilder.append(paramECommerceEntranceInfo.g);
          RIJSPUtils.a(localStringBuilder.toString(), localObject);
        }
        if (bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
          localStringBuilder.append(paramECommerceEntranceInfo.g);
          i = ((Integer)RIJSPUtils.a(localStringBuilder.toString(), localObject)).intValue();
          int k = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramECommerceEntranceInfo.g);
          int j = this.jdField_b_of_type_AndroidUtilSparseIntArray.get(paramECommerceEntranceInfo.g);
          if ((i + j < paramECommerceEntranceInfo.f) && (k < paramECommerceEntranceInfo.e))
          {
            k += 1;
            j += 1;
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramECommerceEntranceInfo.g, k);
            this.jdField_b_of_type_AndroidUtilSparseIntArray.put(paramECommerceEntranceInfo.g, j);
            if (QLog.isColorLevel())
            {
              localObject = jdField_a_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("video_source_id: ");
              localStringBuilder.append(paramECommerceEntranceInfo.g);
              localStringBuilder.append(", one_day_display_counts: ");
              localStringBuilder.append(paramECommerceEntranceInfo.f);
              localStringBuilder.append(", session_display_counts: ");
              localStringBuilder.append(paramECommerceEntranceInfo.e);
              localStringBuilder.append(", session_has_display_counts: ");
              localStringBuilder.append(k);
              localStringBuilder.append(", one_day_has_display_counts: ");
              localStringBuilder.append(i + j);
              QLog.d((String)localObject, 2, localStringBuilder.toString());
            }
            return true;
          }
          return false;
        }
      }
      catch (Exception paramECommerceEntranceInfo)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("解析引流条出现的条件出错: ");
          localStringBuilder.append(paramECommerceEntranceInfo.getMessage());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return false;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShuntBarConfigure
 * JD-Core Version:    0.7.0.1
 */