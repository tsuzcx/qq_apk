package cooperation.gmersdk_warper;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;
import java.util.Map;

class GMEAVEngineWalper$8
  implements GMEAVManager.RoomInfoListener
{
  GMEAVEngineWalper$8(GMEAVEngineWalper paramGMEAVEngineWalper) {}
  
  public void a()
  {
    QLog.e("AVEngineWalper", 1, "onExitRoomComplete");
    if (this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
      this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRoomDisconnect   result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errinfo=");
    localStringBuilder.append(paramString);
    QLog.e("AVEngineWalper", 1, localStringBuilder.toString());
    if (this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
      this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.c(paramInt, paramString);
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString)
  {
    int k = paramArrayOfString.length;
    int j = 0;
    while (j < k)
    {
      String str = paramArrayOfString[j];
      QLog.i("AVEngineWalper", 1, String.format("onEndpointsUpdateInfo|eventid=%d, id=%s", new Object[] { Integer.valueOf(paramInt), str }));
      int i;
      if (this.a.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
        i = ((Integer)this.a.jdField_a_of_type_JavaUtilMap.get(str)).intValue();
      } else {
        i = 0;
      }
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt == 6) {
              i &= 0xFFFFFFFE;
            }
          }
          else {
            i |= 0x1;
          }
        }
        else {
          i &= 0xFFFFFFDF;
        }
      }
      else {
        i |= 0x20;
      }
      if (i != 0) {
        this.a.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(i));
      } else if (this.a.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
        this.a.jdField_a_of_type_JavaUtilMap.remove(str);
      }
      j += 1;
    }
    if (this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
      this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.a(paramInt, paramArrayOfString);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    QLog.e("AVEngineWalper", 1, "onSemiAutoRecvCameraVideo");
    if (this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler != null) {
      this.a.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler.a(paramArrayOfString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper.8
 * JD-Core Version:    0.7.0.1
 */