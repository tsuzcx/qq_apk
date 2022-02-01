package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class QQGameFriendsDialog
  extends ActionSheet
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private QQGameFriendsDialog.FriendAdapter jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameFriendsDialog$FriendAdapter;
  private List<FeedsItemData.FriendInfo> jdField_a_of_type_JavaUtilList;
  
  private String a(long paramLong)
  {
    paramLong = System.currentTimeMillis() / 1000L - paramLong;
    if (paramLong < 60L) {
      return paramLong / 60L + HardCodeUtil.a(2131710261);
    }
    if ((paramLong >= 60L) && (paramLong < 3600L)) {
      return paramLong / 60L + HardCodeUtil.a(2131710264);
    }
    if ((paramLong >= 3600L) && (paramLong < paramLong / 86400L)) {
      return paramLong / 3600L + HardCodeUtil.a(2131710262);
    }
    int i = (int)(paramLong / 86400L);
    if (i >= 30) {
      return i / 30 + HardCodeUtil.a(2131710267);
    }
    if (i >= 7) {
      return i / 7 + HardCodeUtil.a(2131710265);
    }
    return i + HardCodeUtil.a(2131710266);
  }
  
  public void dismiss()
  {
    super.dismiss();
    CmGameUtil.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FriendsManager)CmGameUtil.a().getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramView = (FeedsItemData.FriendInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (TextUtils.isEmpty(paramView.jumpUrl))
    {
      if (paramAdapterView.b(paramView.uin)) {
        paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 1);
      }
      for (paramAdapterView.jdField_h_of_type_JavaLangString = paramView.name;; paramAdapterView.jdField_h_of_type_JavaLangString = paramView.name)
      {
        paramAdapterView.f = paramView.uin;
        paramAdapterView.e = 3000;
        paramAdapterView.g = 2;
        paramAdapterView.jdField_h_of_type_Int = 106;
        ProfileActivity.b(getContext(), paramAdapterView);
        return;
        paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 19);
      }
    }
    paramAdapterView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramAdapterView.putExtra("url", paramView.jumpUrl);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGameFriendsDialog
 * JD-Core Version:    0.7.0.1
 */