package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js;

import android.content.Context;
import com.tencent.falco.utils.SPUtil;
import com.tencent.ilive.interfaces.IAudienceRoomPager;

public class App
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  IAudienceRoomPager jdField_a_of_type_ComTencentIliveInterfacesIAudienceRoomPager;
  boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d;
  
  public App(Context paramContext, IAudienceRoomPager paramIAudienceRoomPager, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentIliveInterfacesIAudienceRoomPager = paramIAudienceRoomPager;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.d = paramBoolean;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentIliveInterfacesIAudienceRoomPager = null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localContext != null)
    {
      bool1 = bool2;
      if (SPUtil.get(localContext, "nowlive_config").getBoolean("scrollForbidden", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.App
 * JD-Core Version:    0.7.0.1
 */