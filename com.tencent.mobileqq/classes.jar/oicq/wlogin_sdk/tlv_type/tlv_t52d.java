package oicq.wlogin_sdk.tlv_type;

import android.content.Context;
import oicq.wlogin_sdk.tools.util;

public class tlv_t52d
  extends tlv_t
{
  public tlv_t52d()
  {
    this._cmd = 1325;
  }
  
  public byte[] get_tlv_52d(Context paramContext)
  {
    paramContext = util.get_android_dev_info(paramContext);
    if ((paramContext != null) && (paramContext.length > 0))
    {
      set_data(paramContext, paramContext.length);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get_tlv_52d success ");
      localStringBuilder.append(paramContext.length);
      util.LOGI(localStringBuilder.toString(), "");
    }
    else
    {
      util.LOGI("get_tlv_52d failed", "");
    }
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t52d
 * JD-Core Version:    0.7.0.1
 */