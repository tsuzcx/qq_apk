package com.tencent.mobileqq.leba;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.view.LebaFeedsVideoView1;

public class LebaFeedsVideoPlayController$VideoPlayParam
{
  public int a;
  public long a;
  public ImageView a;
  public LebaFeedInfo a;
  public LebaFeedsVideoView1 a;
  public String a;
  public long b;
  public ImageView b;
  public String b;
  public long c;
  public String c;
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayParam]");
    localStringBuilder.append(", feedId=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", position=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", coverUrl=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", vid=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", videoUrl=").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", duration=").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", fileSize=").append(this.jdField_c_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaFeedsVideoPlayController.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */