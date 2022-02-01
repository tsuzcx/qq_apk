package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardAioAlbumOption
  extends ForwardBaseOption
{
  public ForwardAioAlbumOption(Intent paramIntent)
  {
    super(paramIntent);
    this.E = true;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() != 1003) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && ((localRecentUser.getType() != 1) || (!c(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.E))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList4 = this.t.getParcelableArrayList("fileinfo_array");
    localArrayList3 = null;
    ArrayList localArrayList1 = localArrayList3;
    if (localArrayList4 != null) {}
    try
    {
      localArrayList1 = (ArrayList)localArrayList4;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        ArrayList localArrayList2 = localArrayList3;
      }
    }
    localArrayList3 = (ArrayList)this.t.get("android.intent.extra.STREAM");
    localArrayList3 = (ArrayList)this.t.get("PhotoConst.PHOTO_PATHS");
    paramIntent.putExtra("dataline_forward_type", 101);
    paramIntent.putExtra("sendMultiple", true);
    if (localArrayList1 == null) {
      paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList3);
    }
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      URLDrawable localURLDrawable = (URLDrawable)paramDrawable;
      if (this.u != null) {
        URLDrawableHelper.decodeLocalImage(localURLDrawable, this.q.getCurrentAccountUin(), false);
      } else {
        URLDrawableHelper.decodeLocalImage(localURLDrawable, this.q.getCurrentAccountUin(), true);
      }
    }
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setBounds(0, 0, D, D);
  }
  
  public void c()
  {
    super.c();
    if (this.r.getBooleanExtra("k_dataline", true))
    {
      this.C.add(g);
      this.C.add(l);
    }
  }
  
  protected void d()
  {
    this.A.setMessage(null);
    this.A.setMessageCount(this.u);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardAioAlbumOption
 * JD-Core Version:    0.7.0.1
 */