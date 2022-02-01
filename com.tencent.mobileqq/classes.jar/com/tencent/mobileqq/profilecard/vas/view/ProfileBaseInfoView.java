package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProfileBaseInfoView
  extends LinearLayout
  implements IProfileContentKey
{
  private static final String TAG = "ProfileMoreInfoView";
  private float mDensity;
  private float mLeftSpace;
  private final HashMap<String, View> mMoreInfoMap = new HashMap();
  
  public ProfileBaseInfoView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ProfileBaseInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private boolean checkAndAddDivider(int paramInt, View paramView)
  {
    Object localObject1 = KEY_MAP_HAS_TOP_DIVIDER;
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (paramView == this.mMoreInfoMap.get(localObject2))
      {
        bool1 = true;
        break label58;
      }
      i += 1;
    }
    boolean bool1 = false;
    label58:
    if (QQTheme.isNowSimpleUI()) {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (getChildCount() == 0) {
        bool2 = false;
      }
    }
    if (bool2)
    {
      localObject1 = String.format("%s_%s", new Object[] { "map_key_divider", Integer.valueOf(paramInt) });
      paramView = (View)this.mMoreInfoMap.get(localObject1);
      if ((paramView != null) && (paramView.getParent() == null)) {
        break label280;
      }
      if (paramView != null) {
        QLog.e("ProfileMoreInfoView", 1, String.format("checkAndAddDivider dividerView=%s viewParent=%s", new Object[] { paramView, paramView.getParent() }));
      }
      i = (int)(this.mDensity * 0.75F);
      paramInt = i;
      if (i < 1) {
        paramInt = 1;
      }
      localObject2 = new LinearLayout.LayoutParams(-1, paramInt);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = ((int)this.mLeftSpace);
      float f = this.mDensity;
      ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(f * 6.0F));
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = ((int)(f * 6.0F));
      paramView = new View(getContext());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.setBackgroundResource(2130852210);
      this.mMoreInfoMap.put(localObject1, paramView);
      label280:
      addView(paramView);
    }
    return bool2;
  }
  
  private void init(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.mDensity = paramContext.getDisplayMetrics().density;
    this.mLeftSpace = (paramContext.getDimensionPixelSize(2131297677) + paramContext.getDimensionPixelSize(2131298261) + paramContext.getDimensionPixelSize(2131298262));
  }
  
  private boolean isDefaultProfile(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramProfileCardInfo != null)
    {
      bool1 = bool2;
      if (paramProfileCardInfo.curUseStyleId == ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public HashMap<String, View> getMoreInfoMap()
  {
    return this.mMoreInfoMap;
  }
  
  public void rebuildProfileContent(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileMoreInfoView", 2, "rebuildProfileContent");
    }
    removeAllViews();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = KEY_MAP_NORMAL;
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = localObject1[i];
      localObject3 = (View)this.mMoreInfoMap.get(localObject2);
      if (localObject3 != null) {
        localArrayList.add(localObject3);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMoreInfoView", 2, String.format("rebuildProfileContent key==%s view=%s", new Object[] { localObject2, localObject3 }));
      }
      i += 1;
    }
    int m = localArrayList.size();
    i = 0;
    int k;
    for (j = 0; i < m; j = k)
    {
      localObject1 = (View)localArrayList.get(i);
      k = j;
      if (isDefaultProfile(paramProfileCardInfo))
      {
        k = j;
        if (checkAndAddDivider(j, (View)localObject1)) {
          k = j + 1;
        }
      }
      localObject2 = ((View)localObject1).getParent();
      if (localObject2 != null)
      {
        QLog.e("ProfileMoreInfoView", 1, String.format("updateMoreInfo itemView=%s viewParent=%s", new Object[] { localObject1, localObject2 }));
        localObject2 = this.mMoreInfoMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          QLog.e("ProfileMoreInfoView", 1, String.format("updateMoreInfo key=%s view=%s", new Object[] { localObject3, this.mMoreInfoMap.get(localObject3) }));
        }
      }
      addView((View)localObject1);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.ProfileBaseInfoView
 * JD-Core Version:    0.7.0.1
 */