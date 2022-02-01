package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForwardMapOption
  extends ForwardBaseOption
{
  public ForwardMapOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && ((localRecentUser.getType() != 1) || (!c(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.E))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      URLDrawableHelper.decodeLocalImage((URLDrawable)paramDrawable, this.q.getCurrentAccountUin(), true);
    }
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setBounds(0, 0, (int)(this.z * 264.0F), (int)(this.z * 138.0F));
  }
  
  protected void b(QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwwardMapOption", 2, "updateImageView:setDefaultDialogPreviewImage");
    }
    a(ForwardOptionUtils.a(this.s.getResources().getDrawable(2130840076), this.z), false, 0);
  }
  
  protected void d()
  {
    String str = this.r.getStringExtra("forward_location_string");
    this.A.setMessage(str);
  }
  
  protected boolean f()
  {
    boolean bool1 = this.t.getBoolean("isFromFavorite", false);
    boolean bool2 = this.r.getBooleanExtra("isFromFavorites", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ForwardMapOption realForwardTo isFromFavorite=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("isFromFav=");
      ((StringBuilder)localObject).append(bool2);
      QLog.d("forward", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(this.s, SplashActivity.class);
    ((Intent)localObject).putExtras(this.t);
    if ((!bool1) && (!bool2))
    {
      if (this.K)
      {
        this.s.startActivity((Intent)localObject);
        this.s.setResult(-1, (Intent)localObject);
        this.s.finish();
      }
      else
      {
        super.f();
      }
    }
    else
    {
      ForwardUtils.a(this.q, this.s, this.I, (Intent)localObject, null);
      this.s.setResult(-1, (Intent)localObject);
      this.s.finish();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMapOption
 * JD-Core Version:    0.7.0.1
 */