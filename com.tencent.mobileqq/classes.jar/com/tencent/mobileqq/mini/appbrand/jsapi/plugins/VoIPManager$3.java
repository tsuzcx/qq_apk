package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alpo;
import bfqt;
import bfqu;
import bfrc;
import bfrf;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

class VoIPManager$3
  extends bfrf
{
  VoIPManager$3(VoIPManager paramVoIPManager) {}
  
  public void onEnterRoom()
  {
    QLog.d("VoIPManager", 1, "onEnterRoom");
    VoIPManager.access$200(this.this$0).set(true);
    bfrc localbfrc = bfqu.a().a();
    if (VoIPManager.access$300(this.this$0) != null) {
      this.this$0.updateMuteConfig(VoIPManager.access$300(this.this$0), null);
    }
    if (localbfrc != null) {
      localbfrc.b();
    }
    VoIPManager.access$000(this.this$0);
  }
  
  public void onError(int paramInt)
  {
    QLog.d("VoIPManager", 1, String.format("onEnterRoom errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 2) || (paramInt == 1)) {
      if (VoIPManager.access$400(this.this$0) != null)
      {
        VoIPManager.access$400(this.this$0).onError(paramInt);
        VoIPManager.access$402(this.this$0, null);
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
      } while (VoIPManager.access$500(this.this$0) == null);
      VoIPManager.access$500(this.this$0).onInterrupt(4, alpo.a(2131717244));
      return;
    } while ((paramInt != 3) || (VoIPManager.access$500(this.this$0) == null));
    VoIPManager.access$500(this.this$0).onInterrupt(3, alpo.a(2131717243));
  }
  
  public void onUserAudioAvailable(bfqt parambfqt, boolean paramBoolean)
  {
    QLog.d("VoIPManager", 1, String.format("onUserAudioAvailable userInfo=%s available=%s", new Object[] { parambfqt, Boolean.valueOf(paramBoolean) }));
  }
  
  public void onUserEnter(bfqt parambfqt)
  {
    QLog.d("VoIPManager", 1, String.format("onUserEnter userInfo=%s", new Object[] { parambfqt }));
    if ((VoIPManager.access$400(this.this$0) == null) && (VoIPManager.access$600(this.this$0, parambfqt.jdField_a_of_type_Long) == null))
    {
      VoIPManager.UserModel localUserModel = new VoIPManager.UserModel(this.this$0, null);
      localUserModel.mUin = parambfqt.jdField_a_of_type_Long;
      localUserModel.mOpenId = parambfqt.jdField_a_of_type_JavaLangString;
      localUserModel.mMicStat = 1;
      VoIPManager.access$800(this.this$0, localUserModel);
      if (VoIPManager.access$500(this.this$0) != null) {
        VoIPManager.access$500(this.this$0).onRoomMemberChange(VoIPManager.access$900(this.this$0));
      }
    }
  }
  
  public void onUserExit(bfqt parambfqt)
  {
    QLog.d("VoIPManager", 1, String.format("onUserExit userInfo=%s", new Object[] { parambfqt }));
    if (VoIPManager.access$400(this.this$0) == null)
    {
      VoIPManager.access$1000(this.this$0, parambfqt.jdField_a_of_type_Long);
      if (VoIPManager.access$500(this.this$0) != null) {
        VoIPManager.access$500(this.this$0).onRoomMemberChange(VoIPManager.access$900(this.this$0));
      }
    }
  }
  
  public void onUserSpeaking(bfqt parambfqt, boolean paramBoolean)
  {
    QLog.d("VoIPManager", 1, String.format("onUserSpeaking userInfo=%s speaking=%s", new Object[] { parambfqt, Boolean.valueOf(paramBoolean) }));
    parambfqt = VoIPManager.access$600(this.this$0, parambfqt.jdField_a_of_type_Long);
    if (parambfqt != null)
    {
      parambfqt.mSpeaking = paramBoolean;
      if (VoIPManager.access$500(this.this$0) != null) {
        VoIPManager.access$500(this.this$0).onRoomMemberSpeaking(VoIPManager.access$1100(this.this$0));
      }
      return;
    }
    QLog.e("VoIPManager", 1, "onUserSpeaking userModel==null");
  }
  
  public void onUserUpdate(List<bfqt> paramList)
  {
    if ((VoIPManager.access$400(this.this$0) != null) && (paramList != null))
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        bfqt localbfqt = (bfqt)localIterator.next();
        if (localbfqt.jdField_a_of_type_Long != 0L) {
          localJSONArray.put(localbfqt.jdField_a_of_type_JavaLangString);
        }
      }
      VoIPManager.access$400(this.this$0).onJoinRoom(localJSONArray);
      VoIPManager.access$1200(this.this$0, paramList);
      VoIPManager.access$402(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.3
 * JD-Core Version:    0.7.0.1
 */