package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.smtt.sdk.QbSdk;

class AIOFileVideoView$6
  implements ShareActionSheet.OnItemClickListener
{
  AIOFileVideoView$6(AIOFileVideoView paramAIOFileVideoView, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem != null)
    {
      if (!(this.b.c instanceof Activity)) {
        return;
      }
      this.b.b.dismiss();
      int i = paramActionSheetItem.action;
      if (i != 2) {
        if (i != 6)
        {
          if (i != 39)
          {
            if (i != 64)
            {
              if (i != 132)
              {
                if (i != 166)
                {
                  if (i != 26)
                  {
                    if (i != 27)
                    {
                      if (i != 72)
                      {
                        if (i != 73) {
                          switch (i)
                          {
                          default: 
                            break;
                          case 56: 
                            AIOFileVideoView.a(this.b, this.a, 2);
                            ReportController.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", AIOFileVideoView.b(this.b, this.a.C), 0, "", "", "", "");
                            break;
                          case 55: 
                            AIOFileVideoView.a(this.b, this.a, 1);
                            ReportController.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", AIOFileVideoView.b(this.b, this.a.C), 0, "", "", "", "");
                            break;
                          case 54: 
                            String str = ParamsManager.a().e();
                            paramShareActionSheet = str;
                            if (TextUtils.isEmpty(str)) {
                              paramShareActionSheet = ParamsManager.a().j();
                            }
                            ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).jumpToTargetAIOPosition((Activity)this.b.c, ParamsManager.a().i(), ParamsManager.a().j(), paramShareActionSheet, this.a.c, this.a.e, this.a.f, false);
                            break;
                          }
                        }
                      }
                      else
                      {
                        AIOFileVideoView.a(this.b, paramActionSheetItem, this.a);
                        break label659;
                      }
                    }
                    else
                    {
                      if ((!AIOFileVideoView.a(this.b)) || (AIOFileVideoView.b(this.b) == null)) {
                        break label659;
                      }
                      AIOFileVideoView.b(this.b).a(this.a.a);
                      QQToast.makeText(this.b.c, this.b.c.getString(2131915733), 0).show();
                      break label659;
                    }
                  }
                  else
                  {
                    if ((!AIOFileVideoView.a(this.b)) || (AIOFileVideoView.b(this.b) == null)) {
                      break label659;
                    }
                    AIOFileVideoView.b(this.b).c(this.a.a);
                    ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
                    QQToast.makeText(this.b.c, 2, this.b.c.getString(2131915732), 0).show();
                    break label659;
                  }
                }
                else
                {
                  ((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity)this.b.c, this.a.l);
                  break label659;
                }
              }
              else
              {
                QbSdk.clearDefaultBrowser(this.b.c, this.a.l);
                QQFileManagerUtil.a((Activity)this.b.c, this.a.l);
                break label659;
              }
            }
            else
            {
              QQFileManagerUtil.a((Activity)this.b.c, this.a.l);
              break label659;
            }
          }
          else
          {
            AIOFileVideoView.b(this.b, this.a);
            break label659;
          }
        }
        else
        {
          if ((!AIOFileVideoView.a(this.b)) || (AIOFileVideoView.b(this.b) == null)) {
            break label659;
          }
          AIOFileVideoView.b(this.b).d(this.a.a);
          break label659;
        }
      }
      AIOFileVideoView.a(this.b, this.a);
      label659:
      ReportController.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", AIOFileVideoView.c(this.b, paramActionSheetItem.action), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.6
 * JD-Core Version:    0.7.0.1
 */