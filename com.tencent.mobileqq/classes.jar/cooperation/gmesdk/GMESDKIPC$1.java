package cooperation.gmesdk;

import android.os.Bundle;
import com.tencent.qqavopensdk.AVEngineEventHandler;
import cooperation.gmersdk_warper.GMEAVEngineWalper;
import java.lang.ref.WeakReference;
import java.util.List;

class GMESDKIPC$1
  extends AVEngineEventHandler
{
  GMESDKIPC$1(GMESDKIPC paramGMESDKIPC, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_exit_room");
      ((GMESDK_Event)this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt != 0) && (paramInt != 1003))
    {
      if ((this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("gmesdk_event_key", "gmesdk_event_key_enterroom");
        localBundle.putInt("gmesdk_event_ret", paramInt);
        localBundle.putString("gmesdk_event_value_eterroom_ret_msg", paramString);
        ((GMESDK_Event)this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
      }
    }
    else {
      GMEAVEngineWalper.a().b(this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.d, this.jdField_a_of_type_Boolean, this.b);
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString)
  {
    if (paramInt != 1)
    {
      int i = 0;
      String str;
      Bundle localBundle;
      if (paramInt != 2)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return;
          }
          paramInt = 0;
          while (paramInt < paramArrayOfString.length)
          {
            str = paramArrayOfString[paramInt];
            if (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaUtilList.contains(str))
            {
              this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaUtilList.remove(str);
              if ((this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
              {
                localBundle = new Bundle();
                localBundle.putString("gmesdk_event_key", "gmesdk_event_key_member_info");
                localBundle.putBoolean("gmesdk_event_key_member_speaking", false);
                localBundle.putString("gmesdk_event_key_member_uin", str);
                ((GMESDK_Event)this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
              }
            }
            paramInt += 1;
          }
        }
        while (i < paramArrayOfString.length)
        {
          str = paramArrayOfString[i];
          if (!this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaUtilList.contains(str))
          {
            this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaUtilList.add(str);
            if ((this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
            {
              localBundle = new Bundle();
              localBundle.putString("gmesdk_event_key", "gmesdk_event_key_member_info");
              localBundle.putBoolean("gmesdk_event_key_member_speaking", true);
              localBundle.putString("gmesdk_event_key_member_uin", str);
              ((GMESDK_Event)this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
            }
          }
          i += 1;
        }
      }
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        str = paramArrayOfString[paramInt];
        if ((this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
        {
          localBundle = new Bundle();
          localBundle.putString("gmesdk_event_key", "gmesdk_event_key_member_info");
          localBundle.putBoolean("gmesdk_event_key_member_speaking", false);
          localBundle.putString("gmesdk_event_key_member_uin", str);
          ((GMESDK_Event)this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Bundle localBundle = new Bundle();
      if (paramBoolean)
      {
        localBundle.putString("gmesdk_event_key", "gmesdk_event_key_open_mic");
        localBundle.putInt("gmesdk_event_ret", paramInt);
      }
      else
      {
        localBundle.putString("gmesdk_event_key", "gmesdk_event_key_close_mic");
        localBundle.putInt("gmesdk_event_ret", paramInt);
      }
      ((GMESDK_Event)this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
    }
  }
  
  public void a(String[] paramArrayOfString) {}
  
  public void b(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_enterroom");
      localBundle.putInt("gmesdk_event_ret", paramInt);
      localBundle.putString("gmesdk_event_value_eterroom_ret_msg", paramString);
      ((GMESDK_Event)this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Bundle localBundle = new Bundle();
      if (paramBoolean)
      {
        localBundle.putString("gmesdk_event_key", "gmesdk_event_key_open_speaker");
        localBundle.putInt("gmesdk_event_ret", paramInt);
      }
      else
      {
        localBundle.putString("gmesdk_event_key", "gmesdk_event_key_close_speaker");
        localBundle.putInt("gmesdk_event_ret", paramInt);
      }
      ((GMESDK_Event)this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_room_disconnect");
      localBundle.putInt("gmesdk_event_ret", paramInt);
      localBundle.putString("gmesdk_event_value_room_disconnect_ret_msg", paramString);
      ((GMESDK_Event)this.jdField_a_of_type_CooperationGmesdkGMESDKIPC.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.gmesdk.GMESDKIPC.1
 * JD-Core Version:    0.7.0.1
 */