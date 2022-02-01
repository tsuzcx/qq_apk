package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

class AIOFilePictureView$3
  implements ShareActionSheet.OnItemClickListener
{
  AIOFilePictureView$3(AIOFilePictureView paramAIOFilePictureView, AIOFilePictureData paramAIOFilePictureData, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem != null)
    {
      if (!(this.c.c instanceof Activity)) {
        return;
      }
      this.c.b.dismiss();
      int i = paramActionSheetItem.action;
      boolean bool;
      if (i != 2) {
        if (i != 6)
        {
          if (i != 39)
          {
            if (i != 52)
            {
              if (i != 64)
              {
                if (i != 69)
                {
                  if (i != 121)
                  {
                    if (i != 132)
                    {
                      if (i != 166)
                      {
                        if (i != 26)
                        {
                          if (i != 27)
                          {
                            Object localObject;
                            if (i != 72)
                            {
                              if (i != 73) {
                                switch (i)
                                {
                                default: 
                                  break;
                                case 56: 
                                  AIOFilePictureView.a(this.c, this.a, 2);
                                  break;
                                case 55: 
                                  AIOFilePictureView.a(this.c, this.a, 1);
                                  ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
                                  break;
                                case 54: 
                                  localObject = ParamsManager.a().e();
                                  paramShareActionSheet = (ShareActionSheet)localObject;
                                  if (TextUtils.isEmpty((CharSequence)localObject)) {
                                    paramShareActionSheet = ParamsManager.a().j();
                                  }
                                  ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).jumpToTargetAIOPosition((Activity)this.c.c, ParamsManager.a().i(), ParamsManager.a().j(), paramShareActionSheet, this.a.c, this.a.e, this.a.f, false);
                                  break;
                                }
                              }
                            }
                            else
                            {
                              i = paramActionSheetItem.uinType;
                              paramShareActionSheet = paramActionSheetItem.uin;
                              if ((!AIOFilePictureView.b(this.c)) || (AIOFilePictureView.a(this.c) == null)) {
                                break label969;
                              }
                              localObject = AIOFilePictureView.a(this.c).c(this.a.a, this.a.b, 0);
                              if (this.a.f == 1) {
                                bool = true;
                              } else {
                                bool = false;
                              }
                              ((IFileDepend)QRoute.api(IFileDepend.class)).forwardToTargetFriend((Activity)this.c.c, (Intent)localObject, bool, paramShareActionSheet, i);
                              break label969;
                            }
                          }
                          else
                          {
                            if ((!AIOFilePictureView.b(this.c)) || (AIOFilePictureView.a(this.c) == null)) {
                              break label969;
                            }
                            AIOFilePictureView.a(this.c).a(this.a.a);
                            QQToast.makeText(this.c.c, this.c.c.getString(2131915733), 0).show();
                            break label969;
                          }
                        }
                        else
                        {
                          if ((!AIOFilePictureView.b(this.c)) || (AIOFilePictureView.a(this.c) == null)) {
                            break label969;
                          }
                          AIOFilePictureView.a(this.c).c(this.a.a);
                          ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
                          QQToast.makeText(this.c.c, 2, this.c.c.getString(2131915732), 0).show();
                          break label969;
                        }
                      }
                      else
                      {
                        ((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity)this.c.c, this.b.getAbsolutePath(), "image/*");
                        break label969;
                      }
                    }
                    else
                    {
                      QbSdk.clearDefaultBrowser(this.c.c, this.b.getPath());
                      QQFileManagerUtil.a((Activity)this.c.c, this.b.getPath());
                      break label969;
                    }
                  }
                  else
                  {
                    if ((!AIOFilePictureView.b(this.c)) || (AIOFilePictureView.a(this.c) == null)) {
                      break label969;
                    }
                    AIOFilePictureView.a(this.c).b(this.a.a);
                    break label969;
                  }
                }
                else
                {
                  ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).sharePicToWXFromPeak(this.b.getPath(), this.c.c);
                  ReportController.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
                  break label969;
                }
              }
              else
              {
                QQFileManagerUtil.a((Activity)this.c.c, this.b.getPath());
                break label969;
              }
            }
            else
            {
              ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment((Activity)this.c.c, this.b.getAbsolutePath(), 1, this.a.f, this.a.w);
              break label969;
            }
          }
          else
          {
            AIOFilePictureView.a(this.c, this.b, this.a);
            break label969;
          }
        }
        else
        {
          if ((!AIOFilePictureView.b(this.c)) || (AIOFilePictureView.a(this.c) == null)) {
            break label969;
          }
          AIOFilePictureView.a(this.c).d(this.a.a);
          break label969;
        }
      }
      if ((AIOFilePictureView.b(this.c)) && (AIOFilePictureView.a(this.c) != null))
      {
        paramShareActionSheet = AIOFilePictureView.a(this.c).c(this.a.a, this.a.b, 0);
        if (this.a.f == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).forwardToFriend((Activity)this.c.c, paramShareActionSheet, bool, ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getSharePanelType(), "");
      }
      label969:
      ReportController.b(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", AIOFilePictureView.a(this.c, paramActionSheetItem.action), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.3
 * JD-Core Version:    0.7.0.1
 */