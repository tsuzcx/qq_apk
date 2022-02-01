package com.tencent.mobileqq.profile.PersonalityLabel;

import java.util.Comparator;

class ProfilePersonalityLabelInfo$ModTimeComparator
  implements Comparator<PersonalityLabelInfo>
{
  ProfilePersonalityLabelInfo$ModTimeComparator(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo) {}
  
  public int a(PersonalityLabelInfo paramPersonalityLabelInfo1, PersonalityLabelInfo paramPersonalityLabelInfo2)
  {
    return -(int)(paramPersonalityLabelInfo1.modTime - paramPersonalityLabelInfo2.modTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo.ModTimeComparator
 * JD-Core Version:    0.7.0.1
 */