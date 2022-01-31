package com.tencent.qqmini.sdk.core.manager;

import bgjp;
import bgjq;
import bgkp;
import bgmu;
import bgnf;
import com.tencent.qqmini.sdk.core.model.InnerShareData;

public class ShareManager$1$1
  implements Runnable
{
  public ShareManager$1$1(bgjp parambgjp, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == -100070004L) || (this.jdField_a_of_type_Long == -1000710003L))
    {
      bgkp.a(this.jdField_a_of_type_Bgjp.a.a, 230, "分享失败", this.jdField_a_of_type_JavaLangString, new bgjq(this), null).show();
      return;
    }
    bgnf.a(this.jdField_a_of_type_Bgjp.a.a, 1, "小程序分享失败，参数错误", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager.1.1
 * JD-Core Version:    0.7.0.1
 */