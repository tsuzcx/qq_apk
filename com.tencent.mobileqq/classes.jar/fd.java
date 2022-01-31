import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class fd
  extends BaseAdapter
{
  private final int jdField_a_of_type_Int = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View.OnClickListener a;
  private DLFilesViewerActivity jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private View.OnClickListener b = new fe(this);
  
  public fd(Context paramContext, DataLineMsgSet paramDataLineMsgSet, DLFilesViewerActivity paramDLFilesViewerActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ff(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
    this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity = paramDLFilesViewerActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static DLFileInfo a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    DLFileInfo localDLFileInfo = new DLFileInfo();
    localDLFileInfo.jdField_b_of_type_JavaLangString = paramDataLineMsgRecord.filename;
    localDLFileInfo.jdField_b_of_type_Long = paramDataLineMsgRecord.filesize;
    localDLFileInfo.jdField_a_of_type_JavaLangString = paramDataLineMsgRecord.path;
    localDLFileInfo.jdField_a_of_type_Long = paramDataLineMsgRecord.sessionid;
    if (paramDataLineMsgRecord.fileMsgStatus == 0L)
    {
      if (!paramDataLineMsgRecord.issuc)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.jdField_a_of_type_Int = 1;
          return localDLFileInfo;
        }
        localDLFileInfo.jdField_a_of_type_Int = 4;
        return localDLFileInfo;
      }
      if (paramDataLineMsgRecord.progress != 1.0F)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.jdField_a_of_type_Int = 0;
          return localDLFileInfo;
        }
        localDLFileInfo.jdField_a_of_type_Int = 3;
        return localDLFileInfo;
      }
      localDLFileInfo.jdField_a_of_type_Int = 5;
      return localDLFileInfo;
    }
    if (paramDataLineMsgRecord.fileMsgStatus == 2L)
    {
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        localDLFileInfo.jdField_a_of_type_Int = 1;
        return localDLFileInfo;
      }
      localDLFileInfo.jdField_a_of_type_Int = 4;
      return localDLFileInfo;
    }
    localDLFileInfo.jdField_a_of_type_Int = 2;
    return localDLFileInfo;
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.strMoloKey != null)
    {
      ajuo localajuo = (ajuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      if ((!paramDataLineMsgRecord.bIsApkFile) || (paramDataLineMsgRecord.nAppStatus == 1))
      {
        int i = localajuo.a(paramDataLineMsgRecord.strMoloKey);
        if (i == 2) {
          aptv.a(2131692856);
        }
        while (i == 0) {
          return;
        }
        aptv.a(2131693888);
        return;
      }
      localajuo.b(paramDataLineMsgRecord.strMoloKey);
      return;
    }
    paramDataLineMsgRecord = paramDataLineMsgRecord.path;
    apue.b(this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity, paramDataLineMsgRecord);
  }
  
  private void a(fh paramfh, DataLineMsgRecord paramDataLineMsgRecord)
  {
    ajuo localajuo = (ajuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramDataLineMsgRecord.strMoloKey != null) {
      localajuo.b(111);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramDataLineMsgRecord.sessionid));
    if (localajuo.a(localArrayList))
    {
      paramfh.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_Int = 3;
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).c(paramDataLineMsgRecord.msgId);
      paramDataLineMsgRecord.issuc = true;
      return;
    }
    aptv.a(2131693945);
  }
  
  private void b(fh paramfh, DataLineMsgRecord paramDataLineMsgRecord)
  {
    ajuo localajuo = (ajuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramfh.jdField_a_of_type_Int == 0) {
      localajuo.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 1, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
    for (;;)
    {
      paramfh.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_Int = 0;
      return;
      localajuo.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 0, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
  }
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    if ((paramListView == null) || (paramLong == 0L)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
    int i = 0;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if ((localDataLineMsgRecord == null) || (localDataLineMsgRecord.sessionid != paramLong)) {}
      }
      else
      {
        paramListView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
        if ((paramListView == null) || (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount())) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getItemBySessionId(paramLong);
        if (localObject == null) {
          break;
        }
        float f = paramFloat;
        if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
          f = ((DataLineMsgRecord)localObject).progress;
        }
        localObject = (ProgressBar)paramListView.findViewById(2131366224);
        if (localObject != null) {
          ((ProgressBar)localObject).setProgress((int)(f * 100.0F));
        }
        paramListView = (TextView)paramListView.findViewById(2131366254);
        if (paramListView == null) {
          break;
        }
        i = (int)(f * 100.0F);
        paramListView.setText(String.valueOf(i) + "%");
        return;
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt == getCount() - 1) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0) {
      return 1;
    }
    return 0;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramInt == getCount() - 1)
    {
      i = 1;
      if (i != 0) {
        break label886;
      }
    }
    label88:
    label94:
    label886:
    for (paramViewGroup = (DataLineMsgRecord)getItem(paramInt);; paramViewGroup = null)
    {
      fh localfh;
      if (paramView == null)
      {
        localfh = new fh(this);
        if (i != 0)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558936, null);
          localfh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365724));
          localfh.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = ((WaitTextView)paramView.findViewById(2131365726));
          paramView.setTag(localfh);
          if (i == 0) {
            break label519;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount() != this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) {
            break label331;
          }
          paramView.setVisibility(4);
          localfh.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
        }
      }
      do
      {
        return paramView;
        i = 0;
        break;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558935, null);
        localfh.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366239));
        localfh.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        localfh.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localfh);
        localfh.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366212));
        localfh.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843403);
        localfh.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localfh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366249));
        localfh.b = ((TextView)paramView.findViewById(2131366253));
        localfh.c = ((TextView)paramView.findViewById(2131366254));
        localfh.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366224));
        localfh.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361887));
        localfh.jdField_a_of_type_AndroidWidgetButton.setTag(localfh);
        localfh.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break label88;
        localfh = (fh)paramView.getTag();
        break label94;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isTimeOut())
        {
          localfh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localfh.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
          paramInt = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
          i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
          paramViewGroup = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693936), new Object[] { Integer.valueOf(i - paramInt) });
          localfh.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText(paramViewGroup);
          localfh.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.a();
          return paramView;
        }
        localfh.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
        localfh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localfh.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
        paramInt = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
        i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
        paramViewGroup = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693934), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i - paramInt) });
        localfh.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText(paramViewGroup);
        return paramView;
        if (paramViewGroup == null)
        {
          localfh.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localfh.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
          return paramView;
        }
        localfh.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localfh.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        localfh.jdField_a_of_type_ComDatalineUtilFileDLFileInfo = a(paramViewGroup);
        localfh.jdField_a_of_type_Int = paramViewGroup.msgtype;
        if ((paramViewGroup.strMoloKey != null) && (paramViewGroup.bIsApkFile))
        {
          localfh.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843403);
          localfh.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramViewGroup.strMoloIconUrl);
        }
        for (;;)
        {
          localfh.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.filename);
          localfh.b.setText(gp.a(paramViewGroup.filesize));
          if ((paramViewGroup.progress != 1.0F) && (paramViewGroup.issuc) && (paramViewGroup.fileMsgStatus != 1L) && (paramViewGroup.fileMsgStatus != 2L)) {
            break label806;
          }
          localfh.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localfh.c.setVisibility(4);
          if ((paramViewGroup.issuc) && (paramViewGroup.fileMsgStatus != 1L) && (paramViewGroup.fileMsgStatus != 2L)) {
            break;
          }
          localfh.jdField_a_of_type_AndroidWidgetButton.setText(2131693946);
          return paramView;
          apue.a(localfh.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramViewGroup);
        }
      } while (paramViewGroup.progress != 1.0F);
      if ((paramViewGroup.strMoloKey == null) || (!paramViewGroup.bIsApkFile) || (paramViewGroup.nAppStatus == 1))
      {
        localfh.jdField_a_of_type_AndroidWidgetButton.setText(2131693933);
        return paramView;
      }
      localfh.jdField_a_of_type_AndroidWidgetButton.setText(2131693915);
      return paramView;
      localfh.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localfh.c.setVisibility(0);
      paramInt = (int)(paramViewGroup.progress * 100.0F);
      localfh.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      localfh.c.setText(String.valueOf(paramInt) + "%");
      localfh.jdField_a_of_type_AndroidWidgetButton.setText(2131693937);
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     fd
 * JD-Core Version:    0.7.0.1
 */