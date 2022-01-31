import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileView;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter.HistoryFileItemHolder;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class rxm
  implements View.OnClickListener
{
  public rxm(ChatHistoryFileView paramChatHistoryFileView) {}
  
  public void onClick(View paramView)
  {
    paramView = (ChatHistoryFileAdapter.HistoryFileItemHolder)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      FileManagerUtil.c(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
      return;
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131428327);
        return;
      }
      FileModel.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_AndroidContentContext, new rxn(this, localFileManagerEntity));
      continue;
      this.a.a(localFileManagerEntity);
      continue;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, localFileManagerEntity.uniseq, false);
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        continue;
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131428327);
          return;
        }
        boolean bool = localFileManagerEntity.isSend();
        FileModel.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_AndroidContentContext, new rxo(this, localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxm
 * JD-Core Version:    0.7.0.1
 */