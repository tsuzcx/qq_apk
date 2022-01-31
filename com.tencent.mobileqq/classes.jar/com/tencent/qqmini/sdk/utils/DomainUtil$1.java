package com.tencent.qqmini.sdk.utils;

import android.widget.Toast;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public final class DomainUtil$1
  implements Runnable
{
  public DomainUtil$1(int paramInt, String paramString) {}
  
  public void run()
  {
    Toast.makeText(MiniAppEnv.g().getContext(), bdyo.a()[this.jdField_a_of_type_Int] + "域名不合法，需使用https或wss协议:" + this.jdField_a_of_type_JavaLangString, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.DomainUtil.1
 * JD-Core Version:    0.7.0.1
 */