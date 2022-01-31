package com.tencent.qqmini.sdk.core.manager;

import bgnw;
import bgnx;
import bgow;
import bgrb;
import bgrm;
import com.tencent.qqmini.sdk.core.model.InnerShareData;

public class ShareManager$1$1
  implements Runnable
{
  public ShareManager$1$1(bgnw parambgnw, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == -100070004L) || (this.jdField_a_of_type_Long == -1000710003L))
    {
      bgow.a(this.jdField_a_of_type_Bgnw.a.a, 230, "分享失败", this.jdField_a_of_type_JavaLangString, new bgnx(this), null).show();
      return;
    }
    bgrm.a(this.jdField_a_of_type_Bgnw.a.a, 1, "小程序分享失败，参数错误", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager.1.1
 * JD-Core Version:    0.7.0.1
 */