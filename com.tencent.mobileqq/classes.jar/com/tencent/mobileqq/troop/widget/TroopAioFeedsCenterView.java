package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TroopAioFeedsCenterView
  extends RelativeLayout
  implements Observer
{
  protected RelativeLayout a;
  protected LinearLayout b;
  protected TextView c;
  protected TroopFeedsDataManager d;
  protected QQAppInterface e;
  protected Context f;
  protected SessionInfo g;
  protected TroopFeedViewFactory h;
  protected boolean i = false;
  
  public TroopAioFeedsCenterView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131627470, this);
  }
  
  public TroopAioFeedsCenterView(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, TroopFeedsCenterLogic paramTroopFeedsCenterLogic)
  {
    super(paramContext);
    this.e = paramQQAppInterface;
    this.f = paramContext;
    this.g = paramSessionInfo;
    this.i = paramBoolean;
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    try
    {
      this.d = localTroopInfoManager.a(Long.valueOf(Long.parseLong(paramSessionInfo.b)), true);
      this.d.addObserver(this);
    }
    catch (Exception paramSessionInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAioFeedsCenterView", 2, paramSessionInfo.toString());
      }
    }
    this.h = new TroopFeedViewFactory(this.e, this.f, this.g, this.d, paramTroopFeedsCenterLogic);
    a(paramQQAppInterface, paramContext);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    inflate(paramContext, 2131626655, this);
    this.a = ((RelativeLayout)findViewById(2131433072));
    this.b = ((LinearLayout)findViewById(2131447430));
    this.c = ((TextView)findViewById(2131447419));
    if (NetworkUtil.isNetSupport(this.f))
    {
      this.c.setText(HardCodeUtil.a(2131912436));
      return;
    }
    this.c.setText(HardCodeUtil.a(2131912447));
  }
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((TroopFeedsDataManager)localObject).d.size() > paramInt))
    {
      localObject = (TroopFeedItem)this.d.d.get(paramInt);
      localObject = this.h.a((TroopFeedItem)localObject, paramInt, true);
      if (localObject != null)
      {
        paramViewGroup.removeAllViews();
        paramViewGroup.addView((View)localObject, 0);
        paramInt = (int)UITools.a(this.f, 15.0F);
        paramViewGroup.setPadding(paramInt, 0, paramInt, 0);
      }
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    if (this.d == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioFeedsCenterView.troop.notification_center.auto_pull_down", 2, "doAutoPullDownLogic");
    }
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    this.c.setText(HardCodeUtil.a(2131912443));
    this.d.a(1002);
  }
  
  void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        if (paramInt >= ((TroopFeedsDataManager)localObject).d.size()) {
          return;
        }
        TroopFeedItem localTroopFeedItem = (TroopFeedItem)this.d.d.get(paramInt);
        if (localTroopFeedItem != null)
        {
          int j = localTroopFeedItem.type;
          if (paramInt == 0) {
            localObject = "0";
          } else {
            localObject = "1";
          }
          if (j != 0) {
            if (j != 5)
            {
              if (j != 10)
              {
                if (j != 12)
                {
                  if (j != 99)
                  {
                    if (j != 18)
                    {
                      if (j != 19)
                      {
                        if (j != 131)
                        {
                          if (j != 132) {
                            break label397;
                          }
                          ReportController.b(this.e, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_music", 0, 0, this.g.b, (String)localObject, "", "");
                          break label397;
                        }
                      }
                      else
                      {
                        ReportController.b(this.e, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_know", 0, 0, this.g.b, (String)localObject, "", "");
                        break label397;
                      }
                    }
                    else
                    {
                      ReportController.b(this.e, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_photo", 0, 0, this.g.b, (String)localObject, "", "");
                      break label397;
                    }
                  }
                  else
                  {
                    ReportController.b(this.e, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_other", 0, 0, this.g.b, (String)localObject, localTroopFeedItem.ex_1, "");
                    break label397;
                  }
                }
                else
                {
                  ReportController.b(this.e, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_vote", 0, 0, this.g.b, (String)localObject, "", "");
                  break label397;
                }
              }
              else
              {
                ReportController.b(this.e, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_video", 0, 0, this.g.b, (String)localObject, "", "");
                break label397;
              }
            }
            else
            {
              ReportController.b(this.e, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_bulletin", 0, 0, this.g.b, (String)localObject, "", "");
              break label397;
            }
          }
          ReportController.b(this.e, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_file", 0, 0, this.g.b, (String)localObject, "", "");
          label397:
          if (localTroopFeedItem.isStoryType()) {
            ReportController.b(this.e, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_story_pgc", 0, 0, this.g.b, "", "", "");
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    if (paramBoolean)
    {
      this.a.setVisibility(8);
      this.b.setVisibility(0);
      this.c.setText(HardCodeUtil.a(2131912445));
    }
    this.h.a();
    this.d.a(1000);
  }
  
  public void b()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    this.c.setText(HardCodeUtil.a(2131912449));
  }
  
  public void c()
  {
    TroopFeedsDataManager localTroopFeedsDataManager = this.d;
    if (localTroopFeedsDataManager != null) {
      localTroopFeedsDataManager.deleteObserver(this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 105))
      {
        if (paramObservable.intValue() == 103)
        {
          this.a.setVisibility(8);
          this.b.setVisibility(0);
          if (NetworkUtil.isNetSupport(this.f))
          {
            this.c.setText(HardCodeUtil.a(2131912446));
            return;
          }
          this.c.setText(HardCodeUtil.a(2131912435));
          return;
        }
        paramObservable.intValue();
        return;
      }
      paramObservable = this.d;
      int j;
      if (paramObservable == null) {
        j = 0;
      } else {
        j = paramObservable.d.size();
      }
      if (j == 0)
      {
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        this.c.setText(HardCodeUtil.a(2131912437));
      }
      else
      {
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        a(this.a, 0);
        a(0);
      }
      if (this.a.getVisibility() == 0) {
        this.a.requestFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView
 * JD-Core Version:    0.7.0.1
 */