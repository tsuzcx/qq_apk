package com.tencent.mobileqq.musicgene;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetAdapter;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MusicPlayerActivity$1
  implements View.OnClickListener
{
  private ActionSheet b = null;
  
  MusicPlayerActivity$1(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject6 = MusicPlayerActivity.a(this.a);
    int j = paramView.getId();
    localObject5 = null;
    Object localObject1 = null;
    i = 0;
    switch (j)
    {
    case 2131439055: 
    case 2131439057: 
    case 2131439058: 
    case 2131439060: 
    default: 
      break;
    case 2131439062: 
      ReportController.b(this.a.app, "CliOper", "", "", "0X800682A", "0X800682A", 0, 0, "", "", "", "");
      localObject5 = paramView.getTag();
      localObject1 = paramView.getContext();
      if (((localObject5 instanceof MusicPlayerActivity.ShareInfo)) && (localObject1 != null))
      {
        localObject5 = (MusicPlayerActivity.ShareInfo)localObject5;
        localObject6 = new ArrayList();
        while (i <= 3)
        {
          ((List)localObject6).add(ActionSheetAdapter.a(i));
          i += 1;
        }
        localObject7 = new ActionSheetAdapter((Context)localObject1);
        ((ActionSheetAdapter)localObject7).a((List)localObject6);
        this.b = ActionSheetAdapter.a((Context)localObject1, (ActionSheetAdapter)localObject7, new MusicPlayerActivity.1.1(this, (MusicPlayerActivity.ShareInfo)localObject5), null, null, true);
        this.b.show();
      }
      break;
    case 2131439061: 
      if (localObject6 == null) {
        break;
      }
    }
    try
    {
      i = ((IQQPlayerService)localObject6).g();
      if (i == 2) {
        break label400;
      }
      if (i == 3) {
        break label390;
      }
      localObject5 = ((IQQPlayerService)localObject6).o();
      if ((localObject5 == null) || (localObject5.length <= 0)) {
        break label989;
      }
      j = ((IQQPlayerService)localObject6).s();
      if (j < 0) {
        break label1002;
      }
      i = j;
      if (j < localObject5.length) {}
    }
    catch (RemoteException localRemoteException3)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        continue;
        Object localObject4 = localObject5[0];
        i = 0;
      }
    }
    Object localObject7 = ((IQQPlayerService)localObject6).r();
    if (!TextUtils.isEmpty((CharSequence)localObject7))
    {
      ((IQQPlayerService)localObject6).a((String)localObject7, (SongInfo[])localObject5, i);
      if (localObject1 != null)
      {
        localObject5 = MusicPlayerActivity.a(this.a, (SongInfo)localObject1);
        if (MusicPlayerActivity.b().containsKey(localObject5))
        {
          localObject5 = (MusicPlayerActivity.SimpleSongInfo)MusicPlayerActivity.b().get(localObject5);
          localObject1 = MusicPlayerActivity.a(this.a, (IQQPlayerService)localObject6, (SongInfo)localObject1, ((MusicPlayerActivity.SimpleSongInfo)localObject5).a);
          MusicPlayerActivity.a(this.a, (MusicPlayerActivity.SimpleSongInfo)localObject5, (String)localObject1);
          break label989;
          label390:
          ((IQQPlayerService)localObject6).b();
          break label989;
          label400:
          ((IQQPlayerService)localObject6).a();
          break label989;
          if (localObject6 != null)
          {
            localObject1 = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
            try
            {
              localObject5 = ((IQQPlayerService)localObject6).k();
              if (localObject5 == null) {
                break label989;
              }
              localObject5 = MusicPlayerActivity.a(this.a, (SongInfo)localObject5);
              if (!MusicPlayerActivity.a().containsKey(localObject5)) {
                break label989;
              }
              localObject6 = paramView.getTag();
              if (paramView.isSelected())
              {
                ReportController.b(this.a.app, "CliOper", "", "", "0X8006829", "0X8006829", 0, 0, "", "", "", "");
                MusicPlayerActivity.c(this.a).a((String)localObject1, this.a.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject5)).longValue(), false);
                paramView.setSelected(false);
                MusicPlayerActivity.d(this.a).setImageResource(2130842193);
                if ((localObject6 instanceof Integer))
                {
                  i = ((Integer)localObject6).intValue();
                  MusicPlayerActivity.a(this.a, 2130842193, i);
                }
              }
              else
              {
                ReportController.b(this.a.app, "CliOper", "", "", "0X8006828", "0X8006828", 0, 0, "", "", "", "");
                MusicPlayerActivity.c(this.a).a((String)localObject1, this.a.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject5)).longValue(), true);
                paramView.setSelected(true);
                MusicPlayerActivity.d(this.a).setImageResource(2130842192);
                if ((localObject6 instanceof Integer))
                {
                  i = ((Integer)localObject6).intValue();
                  MusicPlayerActivity.a(this.a, 2130842192, i);
                }
              }
            }
            catch (RemoteException localRemoteException1)
            {
              QLog.e("MusicPlayerActivity", 1, "add favourite RemoteException ", localRemoteException1);
            }
            ReportController.b(this.a.app, "CliOper", "", "", "0X800682B", "0X800682B", 0, 0, "", "", "", "");
            if (QQMusicConst.a(this.a, "com.tencent.qqmusic"))
            {
              localObject2 = localObject5;
              if (localObject6 != null) {
                try
                {
                  localObject2 = ((IQQPlayerService)localObject6).k();
                }
                catch (RemoteException localRemoteException2)
                {
                  QLog.e("MusicPlayerActivity", 1, "music player activity RemoteException ", localRemoteException2);
                  localObject3 = localObject5;
                }
              }
              if (localObject3 != null)
              {
                localObject3 = MusicPlayerActivity.a(this.a, (SongInfo)localObject3);
                if (MusicPlayerActivity.a().containsKey(localObject3))
                {
                  localObject3 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("androidqqmusic://form=webpage&mid=23&k1=0&k2=%s&download=1&action=download", new Object[] { String.valueOf(MusicPlayerActivity.a().get(localObject3)) })));
                  ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_qqmusic");
                  this.a.startActivity((Intent)localObject3);
                  ReportController.b(this.a.app, "CliOper", "", "", "0X800682C", "0X800682C", 0, 0, "", "", "", "");
                }
              }
            }
            else
            {
              localObject3 = (ActionSheet)ActionSheetHelper.b(this.a, null);
              ((ActionSheet)localObject3).setMainTitle(2131892042);
              ((ActionSheet)localObject3).addButton(2131892044, 2);
              ((ActionSheet)localObject3).addCancelButton(2131892041);
              ((ActionSheet)localObject3).setOnButtonClickListener(new MusicPlayerActivity.1.2(this, paramView, (ActionSheet)localObject3));
              ((ActionSheet)localObject3).show();
              break label989;
              this.a.finish();
            }
          }
        }
      }
    }
    label989:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1
 * JD-Core Version:    0.7.0.1
 */