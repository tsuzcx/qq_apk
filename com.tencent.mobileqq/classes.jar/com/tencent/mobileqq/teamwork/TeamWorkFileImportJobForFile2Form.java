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
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null) && (paramAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler != null))
    {
      localObject1 = CommonUtils.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.n;
      if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int != 6000) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int != 6003))
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
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.c;
          if (!new File((String)localObject1).exists()) {
            break;
          }
          localObject1 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).getFileMD5((String)localObject1);
        }
        localObject1 = "";
      }
      i = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int;
      l3 = 0L;
      if (i == 1)
      {
        i = 3;
        l3 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString).longValue();
        l2 = 0L;
        l1 = l2;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000)
      {
        l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString).longValue();
        i = 2;
        l1 = 0L;
      }
      else
      {
        localObject4 = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).queryMsgItemByUniseq(paramAppInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Long);
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
        paramAppInterface.put("filename", this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
        paramAppInterface.put("filesize", this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d);
        paramAppInterface.put("filetype", i);
        paramAppInterface.put("businesstype", this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_Int);
        paramAppInterface.put("groupuin", l3);
        paramAppInterface.put("senderuin", l1);
        paramAppInterface.put("discussuin", l2);
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.h;
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
      this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.g == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.addToFileImportingMap(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.importFormWithLocalFile(paramAppInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.g == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.addToFileImportingMap(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.importFormWithUrl(paramAppInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.checkFormCache(paramAppInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
      return;
      label625:
      Object localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForFile2Form
 * JD-Core Version:    0.7.0.1
 */