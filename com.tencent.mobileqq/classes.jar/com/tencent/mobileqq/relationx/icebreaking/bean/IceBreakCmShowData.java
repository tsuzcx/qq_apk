package com.tencent.mobileqq.relationx.icebreaking.bean;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import java.net.URL;
import org.json.JSONObject;

public class IceBreakCmShowData
  implements IStickerRecEmoticon
{
  private JSONObject a;
  
  public IceBreakCmShowData(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    return null;
  }
  
  public void a(long paramLong) {}
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt) {}
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void b(long paramLong) {}
  
  public boolean b()
  {
    return false;
  }
  
  public URLDrawable.URLDrawableOptions c()
  {
    return null;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public String e()
  {
    return null;
  }
  
  public String f()
  {
    return null;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public int h()
  {
    return 0;
  }
  
  public int i()
  {
    return 0;
  }
  
  public int j()
  {
    return 0;
  }
  
  public URL k()
  {
    return null;
  }
  
  public String l()
  {
    return null;
  }
  
  public String m()
  {
    return null;
  }
  
  public JSONObject n()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.bean.IceBreakCmShowData
 * JD-Core Version:    0.7.0.1
 */