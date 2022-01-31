package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajjy;
import bcng;
import bcnh;
import bcnp;
import bcns;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

class VoIPManager$3
  extends bcns
{
  VoIPManager$3(VoIPManager paramVoIPManager) {}
  
  public void onEnterRoom()
  {
    QLog.d("VoIPManager", 1, "onEnterRoom");
    VoIPManager.access$100(this.this$0).set(true);
    bcnp localbcnp = bcnh.a().a();
    if (VoIPManager.access$200(this.this$0) != null) {
      this.this$0.updateMuteConfig(VoIPManager.access$200(this.this$0), null);
    }
    if (localbcnp != null) {
      localbcnp.b();
    }
    VoIPManager.access$000(this.this$0, -1);
  }
  
  public void onError(int paramInt)
  {
    QLog.d("VoIPManager", 1, String.format("onEnterRoom errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 2) || (paramInt == 1)) {
      if (VoIPManager.access$300(this.this$0) != null)
      {
        VoIPManager.access$300(this.this$0).onError(paramInt);
        VoIPManager.access$302(this.this$0, null);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 4) {
          break;
        }
      } while (VoIPManager.access$400(this.this$0) == null);
      VoIPManager.access$400(this.this$0).onInterrupt(4, ajjy.a(2131651070));
      return;
    } while ((paramInt != 3) || (VoIPManager.access$400(this.this$0) == null));
    VoIPManager.access$400(this.this$0).onInterrupt(3, ajjy.a(2131651069));
  }
  
  public void onUserAudioAvailable(bcng parambcng, boolean paramBoolean)
  {
    QLog.d("VoIPManager", 1, String.format("onUserAudioAvailable userInfo=%s available=%s", new Object[] { parambcng, Boolean.valueOf(paramBoolean) }));
  }
  
  public void onUserEnter(bcng parambcng)
  {
    QLog.d("VoIPManager", 1, String.format("onUserEnter userInfo=%s", new Object[] { parambcng }));
    if ((VoIPManager.access$300(this.this$0) == null) && (VoIPManager.access$500(this.this$0, parambcng.jdField_a_of_type_Long) == null))
    {
      VoIPManager.UserModel localUserModel = new VoIPManager.UserModel(this.this$0, null);
      localUserModel.mUin = parambcng.jdField_a_of_type_Long;
      localUserModel.mOpenId = parambcng.jdField_a_of_type_JavaLangString;
      localUserModel.mMicStat = 1;
      VoIPManager.access$700(this.this$0, localUserModel);
      if (VoIPManager.access$400(this.this$0) != null) {
        VoIPManager.access$400(this.this$0).onRoomMemberChange(VoIPManager.access$800(this.this$0));
      }
    }
  }
  
  public void onUserExit(bcng parambcng)
  {
    QLog.d("VoIPManager", 1, String.format("onUserExit userInfo=%s", new Object[] { parambcng }));
    if (VoIPManager.access$300(this.this$0) == null)
    {
      VoIPManager.access$900(this.this$0, parambcng.jdField_a_of_type_Long);
      if (VoIPManager.access$400(this.this$0) != null) {
        VoIPManager.access$400(this.this$0).onRoomMemberChange(VoIPManager.access$800(this.this$0));
      }
    }
  }
  
  public void onUserSpeaking(bcng parambcng, boolean paramBoolean)
  {
    QLog.d("VoIPManager", 1, String.format("onUserSpeaking userInfo=%s speaking=%s", new Object[] { parambcng, Boolean.valueOf(paramBoolean) }));
    parambcng = VoIPManager.access$500(this.this$0, parambcng.jdField_a_of_type_Long);
    if (parambcng != null)
    {
      parambcng.mSpeaking = paramBoolean;
      if (VoIPManager.access$400(this.this$0) != null) {
        VoIPManager.access$400(this.this$0).onRoomMemberSpeaking(VoIPManager.access$1000(this.this$0));
      }
      return;
    }
    QLog.e("VoIPManager", 1, "onUserSpeaking userModel==null");
  }
  
  public void onUserUpdate(List<bcng> paramList)
  {
    if ((VoIPManager.access$300(this.this$0) != null) && (paramList != null))
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        bcng localbcng = (bcng)localIterator.next();
        if (localbcng.jdField_a_of_type_Long != 0L) {
          localJSONArray.put(localbcng.jdField_a_of_type_JavaLangString);
        }
      }
      VoIPManager.access$300(this.this$0).onJoinRoom(localJSONArray);
      VoIPManager.access$1100(this.this$0, paramList);
      VoIPManager.access$302(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.3
 * JD-Core Version:    0.7.0.1
 */