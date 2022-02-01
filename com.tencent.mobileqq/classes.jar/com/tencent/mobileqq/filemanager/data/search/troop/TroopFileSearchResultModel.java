package com.tencent.mobileqq.filemanager.data.search.troop;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.UUID;

public class TroopFileSearchResultModel
  implements ISearchResultModel
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileSearchItemData jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  
  public TroopFileSearchResultModel(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, TroopFileSearchItemData paramTroopFileSearchItemData)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData = paramTroopFileSearchItemData;
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
  }
  
  private CharSequence a(TroopFileInfo paramTroopFileInfo)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList;
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramTroopFileInfo.jdField_c_of_type_JavaLangString))
        {
          localObject1 = localObject2;
          if (paramTroopFileInfo.jdField_c_of_type_JavaLangString.toLowerCase().contains("".toLowerCase())) {
            localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.get(0);
          }
        }
      }
    }
    localObject2 = paramTroopFileInfo.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = SearchUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString, (String)localObject1);
    }
    return localObject2;
  }
  
  private void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData;
    if (localObject1 == null) {
      return;
    }
    String str2 = "";
    long l1 = ((TroopFileSearchItemData)localObject1).jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_b_of_type_Long;
    long l3 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_c_of_type_Long;
    TroopFileInfo localTroopFileInfo = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(l1), String.valueOf(l2));
    int i;
    if ((localObject1 != null) && (ContactUtils.a(((TroopMemberInfo)localObject1).troopnick, String.valueOf(l3)))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      str1 = ((TroopMemberInfo)localObject1).troopnick;
    } else {
      str1 = null;
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_c_of_type_Long > 0L)
    {
      localObject3 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_c_of_type_Long);
      TroopFileSearchManager localTroopFileSearchManager = TroopFileSearchManager.a();
      localObject1 = localTroopFileSearchManager.a((String)localObject3);
      if (localObject1 != null)
      {
        i = TroopFileSearchManager.a(this.jdField_a_of_type_JavaLangString, str1, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_c_of_type_JavaLangString, ((ContactSearchableFriend)localObject1).jdField_c_of_type_JavaLangString, ((ContactSearchableFriend)localObject1).d, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.d, ((ContactSearchableFriend)localObject1).jdField_a_of_type_JavaLangString, ((ContactSearchableFriend)localObject1).jdField_b_of_type_JavaLangString);
        str1 = TroopFileSearchManager.a(str1, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.d, i);
      }
      else
      {
        i = TroopFileSearchManager.a(this.jdField_a_of_type_JavaLangString, str1, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_c_of_type_JavaLangString, null, null, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.d, null, null);
        str1 = TroopFileSearchManager.a(str1, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.d, i);
      }
      if (TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_c_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.d;
          localObject2 = str2;
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_c_of_type_JavaLangString;
          localObject2 = str2;
        }
      }
      else if ((i != 1) && (i != 4) && (i != 7))
      {
        if ((i != 5) && (i != 6) && (i != 2))
        {
          localObject1 = str1;
          localObject2 = str2;
          if (i != 3) {}
        }
        else
        {
          localObject2 = localTroopFileSearchManager.a(this.jdField_a_of_type_JavaLangString, (String)localObject3);
          localObject1 = str1;
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        localObject1 = str1;
      }
    }
    else
    {
      if (i == 0) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_b_of_type_JavaLangString;
      }
      localObject1 = str1;
      localObject2 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = str1;
        localObject2 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject3 = (String)this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.get(0);
          localObject1 = str1;
          localObject2 = str2;
          if (!TextUtils.isEmpty(str1))
          {
            localObject1 = str1;
            localObject2 = str2;
            if (str1.toLowerCase().contains(((String)localObject3).toLowerCase()))
            {
              localObject2 = localObject3;
              localObject1 = str1;
            }
          }
        }
      }
    }
    String str1 = localTroopFileInfo.a();
    str2 = localTroopFileInfo.m;
    Object localObject3 = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject3).append(str2).append("  ");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((SpannableStringBuilder)localObject3).append(SearchUtils.a((String)localObject1, (String)localObject2)).append("  ");
    } else {
      ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1).append("  ");
    }
    ((SpannableStringBuilder)localObject3).append(str1);
    this.b = ((CharSequence)localObject3);
    this.jdField_a_of_type_JavaLangCharSequence = a(localTroopFileInfo);
  }
  
  public int a()
  {
    return 0;
  }
  
  public CharSequence a()
  {
    return this.b;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(View paramView)
  {
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_Long);
    TroopFileInfo localTroopFileInfo = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    TroopFileStatusInfo localTroopFileStatusInfo = ((TroopFileTransferManager)localObject).a(localTroopFileInfo.jdField_b_of_type_JavaLangString);
    localObject = localTroopFileStatusInfo;
    if (localTroopFileStatusInfo == null)
    {
      localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_Long, localTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString(), localTroopFileInfo.jdField_b_of_type_JavaLangString, localTroopFileInfo.jdField_c_of_type_JavaLangString, localTroopFileInfo.jdField_a_of_type_Long, localTroopFileInfo.jdField_a_of_type_Int);
      ((TroopFileStatusInfo)localObject).jdField_c_of_type_JavaLangString = localTroopFileInfo.k;
      ((TroopFileStatusInfo)localObject).d = localTroopFileInfo.l;
      ((TroopFileStatusInfo)localObject).jdField_b_of_type_JavaLangString = localTroopFileInfo.j;
    }
    if ((localObject != null) && (((TroopFileStatusInfo)localObject).jdField_c_of_type_Long == 0L)) {
      ((TroopFileStatusInfo)localObject).jdField_c_of_type_Long = localTroopFileInfo.jdField_a_of_type_Long;
    }
    int i = FileManagerUtil.a(((TroopFileStatusInfo)localObject).g);
    if ((i != 0) && (i != 2))
    {
      QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (TroopFileStatusInfo)localObject, localTroopFileInfo.f, localTroopFileInfo.jdField_c_of_type_Int, 4, false);
      return;
    }
    paramView = QFileUtils.a(paramView.findViewById(2131366781), localTroopFileInfo.jdField_c_of_type_JavaLangString);
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_Long, (TroopFileStatusInfo)localObject, localTroopFileInfo.f, localTroopFileInfo.jdField_c_of_type_Int, 2, 4, paramView, false, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public CharSequence b()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    return null;
  }
  
  public String c()
  {
    Object localObject1 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_Long);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    TroopFileStatusInfo localTroopFileStatusInfo = ((TroopFileTransferManager)localObject1).a(((TroopFileInfo)localObject2).jdField_b_of_type_JavaLangString);
    if (localTroopFileStatusInfo != null)
    {
      localObject1 = localTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
    }
    else
    {
      ((TroopFileTransferManager)localObject1).a(((TroopFileInfo)localObject2).jdField_a_of_type_JavaUtilUUID, 128);
      localObject1 = "";
    }
    localObject2 = localObject1;
    if (!FileUtils.fileExistsAndNotEmpty((String)localObject1)) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.j;
    }
    return localObject2;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public int f_()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchResultModel
 * JD-Core Version:    0.7.0.1
 */