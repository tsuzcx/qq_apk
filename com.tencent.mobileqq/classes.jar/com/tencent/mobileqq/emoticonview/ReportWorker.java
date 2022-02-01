package com.tencent.mobileqq.emoticonview;

import android.util.SparseIntArray;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.VasVipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class ReportWorker
  implements Runnable
{
  private static final String TAG = "ReportWorker";
  private BaseQQAppInterface mAppInterface;
  private int mCurType;
  private boolean mIsForward;
  private String mMsg;
  private WeakReference<IEmoticonMainPanel> mPanelReference;
  
  public ReportWorker(String paramString, boolean paramBoolean, IEmoticonMainPanel paramIEmoticonMainPanel, BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    this.mMsg = paramString;
    this.mIsForward = paramBoolean;
    this.mAppInterface = paramBaseQQAppInterface;
    this.mPanelReference = new WeakReference(paramIEmoticonMainPanel);
    this.mCurType = paramInt;
  }
  
  public void run()
  {
    Object localObject1 = this.mMsg;
    if (localObject1 != null)
    {
      if ("".equals(localObject1)) {
        return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder(this.mMsg);
      ArrayList localArrayList = new ArrayList();
      int j;
      for (int i = 0; i < localStringBuilder1.length(); i = j + 1)
      {
        j = localStringBuilder1.codePointAt(i);
        int k;
        Object localObject2;
        if ((j == 20) && (i < localStringBuilder1.length() - 1))
        {
          k = i + 1;
          int m = localStringBuilder1.charAt(k);
          if ((m >= EmotcationConstants.VALID_SYS_EMOTCATION_COUNT) && (250 != m))
          {
            j = i;
            if (m == 255)
            {
              m = i + 4;
              if (m >= localStringBuilder1.length()) {
                return;
              }
              localObject1 = new char[4];
              localObject1[0] = localStringBuilder1.charAt(m);
              localObject1[1] = localStringBuilder1.charAt(i + 3);
              localObject1[2] = localStringBuilder1.charAt(i + 2);
              localObject1[3] = localStringBuilder1.charAt(k);
              i = 0;
              while (i < 3)
              {
                if (localObject1[i] == 'ú') {
                  localObject1[i] = 10;
                } else if (localObject1[i] == 'þ') {
                  localObject1[i] = 13;
                }
                i += 1;
              }
              localObject1 = EmosmUtils.a((char[])localObject1);
              if ((localObject1 != null) && (localObject1.length == 2))
              {
                j = localObject1[0];
                i = localObject1[1];
              }
              else
              {
                i = 0;
                j = 0;
              }
              localObject1 = this.mPanelReference;
              if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
                k = ((IEmoticonMainPanel)this.mPanelReference.get()).getEmoticonTab(Integer.toString(j));
              } else {
                k = -1;
              }
              localObject2 = Integer.toString(k);
              if (this.mIsForward) {
                localObject1 = "0X800588C";
              } else {
                localObject1 = "0X80057AF";
              }
              BaseQQAppInterface localBaseQQAppInterface = this.mAppInterface;
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(j);
              ((StringBuilder)localObject3).append("");
              localObject3 = ((StringBuilder)localObject3).toString();
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append(i);
              localStringBuilder2.append("");
              ReportController.b(localBaseQQAppInterface, "CliOper", "", "", "ep_mall", (String)localObject1, 0, 0, (String)localObject3, localStringBuilder2.toString(), (String)localObject2, "");
              EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus("0", 5);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("report small emoticon send amount, epId:");
                ((StringBuilder)localObject1).append(j);
                ((StringBuilder)localObject1).append(",eId:");
                ((StringBuilder)localObject1).append(i);
                ((StringBuilder)localObject1).append(",tabOrder:");
                ((StringBuilder)localObject1).append((String)localObject2);
                QLog.d("ReportWorker", 2, ((StringBuilder)localObject1).toString());
              }
              j = m;
            }
          }
          else
          {
            k = m;
            if (250 == m) {
              k = 10;
            }
            localObject1 = this.mAppInterface;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(k);
            ((StringBuilder)localObject2).append("");
            ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "0X80057A3", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
            if (TextUtils.isApolloEmoticon(k))
            {
              VasVipUtils.a(this.mAppInterface, "cmshow", "Apollo", "0X800812E", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.mCurType), 0, new String[] { String.valueOf(k), String.valueOf(((IApolloManagerService)this.mAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus()) });
              localArrayList.add(Integer.valueOf(QQSysFaceUtil.convertToServer(k)));
            }
            EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus("0", 1);
            j = i;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("report emoji send amount, index:");
              ((StringBuilder)localObject1).append(k);
              QLog.d("ReportWorker", 2, ((StringBuilder)localObject1).toString());
              j = i;
            }
          }
        }
        else
        {
          k = EmotcationConstants.EMOJI_MAP.get(j, -1);
          j = i;
          if (k >= 0)
          {
            localObject1 = this.mAppInterface;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(k);
            ((StringBuilder)localObject2).append("");
            ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "0X80057A4", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
            EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus("0", 1);
            j = i;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("report system emoticon send amount, emoIdx:");
              ((StringBuilder)localObject1).append(k);
              QLog.d("ReportWorker", 2, ((StringBuilder)localObject1).toString());
              j = i;
            }
          }
        }
      }
      try
      {
        ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).apolloCmEmojiSendReport(localArrayList, this.mAppInterface, this.mCurType);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReportWorker", 2, "report apolloCmEmojiSendReport error!", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ReportWorker
 * JD-Core Version:    0.7.0.1
 */