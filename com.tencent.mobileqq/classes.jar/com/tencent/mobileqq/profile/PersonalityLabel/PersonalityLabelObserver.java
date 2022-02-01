package com.tencent.mobileqq.profile.PersonalityLabel;

import com.tencent.mobileqq.app.BusinessObserver;

public class PersonalityLabelObserver
  implements BusinessObserver
{
  public void onDelPersonalityLabelPhoto(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {}
  
  public void onGetPersonalityLabel(boolean paramBoolean, String paramString, ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, byte[] paramArrayOfByte, int paramInt) {}
  
  public void onGetPersonalityLabelPhotos(boolean paramBoolean, String paramString, long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return;
        }
        paramObject = (Object[])paramObject;
        if (paramBoolean)
        {
          onDelPersonalityLabelPhoto(true, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
          return;
        }
        if (paramObject != null) {
          onDelPersonalityLabelPhoto(false, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
        }
      }
      else
      {
        paramObject = (Object[])paramObject;
        if (paramBoolean)
        {
          onGetPersonalityLabelPhotos(true, (String)paramObject[0], ((Long)paramObject[1]).longValue(), (PersonalityLabelInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (byte[])paramObject[4]);
          return;
        }
        if ((paramObject != null) && (paramObject.length > 0))
        {
          onGetPersonalityLabelPhotos(false, (String)paramObject[0], ((Long)paramObject[1]).longValue(), null, 0, null);
          return;
        }
        onGetPersonalityLabelPhotos(false, "", -1L, null, 0, null);
      }
    }
    else
    {
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        onGetPersonalityLabel(true, (String)paramObject[0], (ProfilePersonalityLabelInfo)paramObject[1], (byte[])paramObject[2], ((Integer)paramObject[3]).intValue());
        return;
      }
      onGetPersonalityLabel(false, null, null, null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelObserver
 * JD-Core Version:    0.7.0.1
 */