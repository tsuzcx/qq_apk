package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkFileImportJobForFile2Form
  extends TeamWorkFileImportJob
{
  public TeamWorkFileImportJobForFile2Form(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, AppInterface paramAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramAppInterface);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    Object localObject1;
    Object localObject4;
    Object localObject3;
    label159:
    int i;
    long l3;
    long l2;
    long l1;
    if ((this.b != null) && (paramAppInterface != null) && (this.c != null))
    {
      localObject1 = CommonUtils.a(this.b);
      localObject4 = this.b.G;
      if ((this.b.a != 6000) && (this.b.a != 6003))
      {
        localObject3 = localObject1;
        localObject1 = "";
      }
      else
      {
        localObject3 = "";
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        while (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = localObject4;
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            break label159;
          }
          localObject1 = this.b.d;
          if (!new File((String)localObject1).exists()) {
            break;
          }
          localObject1 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).getFileMD5((String)localObject1);
        }
        localObject1 = "";
      }
      i = this.b.a;
      l3 = 0L;
      if (i == 1)
      {
        i = 3;
        l3 = Long.valueOf(this.b.b).longValue();
        l2 = 0L;
        l1 = l2;
      }
      else if (this.b.a == 3000)
      {
        l2 = Long.valueOf(this.b.b).longValue();
        i = 2;
        l1 = 0L;
      }
      else
      {
        localObject4 = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).queryMsgItemByUniseq(paramAppInterface, this.b.b, this.b.a, this.b.e);
        if ((localObject4 != null) && (((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).isInstanceMessageForFile((MessageRecord)localObject4))) {
          l1 = Long.valueOf(((MessageRecord)localObject4).senderuin).longValue();
        } else {
          l1 = 0L;
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          l1 = Long.valueOf(paramAppInterface.getCurrentAccountUin()).longValue();
        }
        l2 = 0L;
        i = 1;
      }
      paramAppInterface = new JSONObject();
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label625;
        }
        paramAppInterface.put("fileid", localObject1);
        paramAppInterface.put("filename", this.b.c);
        paramAppInterface.put("filesize", this.b.K);
        paramAppInterface.put("filetype", i);
        paramAppInterface.put("businesstype", this.b.h);
        paramAppInterface.put("groupuin", l3);
        paramAppInterface.put("senderuin", l1);
        paramAppInterface.put("discussuin", l2);
        boolean bool = this.b.I;
        if (bool) {
          paramAppInterface.put("ownertype", 1);
        } else {
          paramAppInterface.put("ownertype", 2);
        }
      }
      catch (JSONException localJSONException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("put fileid exception: ");
        ((StringBuilder)localObject4).append(localJSONException.toString());
        QLog.e("TeamWorkFileImportJobForFile2Form", 2, ((StringBuilder)localObject4).toString());
      }
      this.b.m = true;
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (this.b.B == 0))
      {
        this.c.addToFileImportingMap(this.b);
        this.c.importFormWithLocalFile(paramAppInterface, this.b);
        return;
      }
      if (this.b.B == 0)
      {
        this.c.addToFileImportingMap(this.b);
        this.c.importFormWithUrl(paramAppInterface, this.b);
        return;
      }
      this.c.checkFormCache(paramAppInterface, this.b);
      return;
      label625:
      Object localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForFile2Form
 * JD-Core Version:    0.7.0.1
 */