package com.tencent.mobileqq.profile.view;

import android.widget.ToggleButton;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import java.util.HashMap;
import java.util.Map;

public class ProfileLabelPanel$LabelStatusManager
{
  private Map<ProfileLabelInfo, ToggleButton> a = new HashMap();
  
  public ToggleButton a(ProfileLabelInfo paramProfileLabelInfo)
  {
    return (ToggleButton)this.a.get(paramProfileLabelInfo);
  }
  
  public Map<ProfileLabelInfo, ToggleButton> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton)
  {
    if (!a(paramProfileLabelInfo)) {
      this.a.put(paramProfileLabelInfo, paramToggleButton);
    }
  }
  
  public boolean a(ProfileLabelInfo paramProfileLabelInfo)
  {
    return this.a.get(paramProfileLabelInfo) != null;
  }
  
  public void b(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton)
  {
    if (a(paramProfileLabelInfo)) {
      this.a.remove(paramProfileLabelInfo);
    }
  }
  
  public void c(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton)
  {
    if (paramProfileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_NORMAL) {
      a(paramProfileLabelInfo, paramToggleButton);
    } else if (paramProfileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
      b(paramProfileLabelInfo, paramToggleButton);
    }
    paramProfileLabelInfo.toggleStatus();
    paramToggleButton.toggle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanel.LabelStatusManager
 * JD-Core Version:    0.7.0.1
 */