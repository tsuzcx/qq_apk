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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dm
  extends BaseAdapter
{
  private final int jdField_a_of_type_Int = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View.OnClickListener a;
  private DLFilesViewerActivity jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private View.OnClickListener b = new dn(this);
  
  public dm(Context paramContext, DataLineMsgSet paramDataLineMsgSet, DLFilesViewerActivity paramDLFilesViewerActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new do(this);
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
      alqo localalqo = (alqo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      if ((!paramDataLineMsgRecord.bIsApkFile) || (paramDataLineMsgRecord.nAppStatus == 1))
      {
        int i = localalqo.a(paramDataLineMsgRecord.strMoloKey);
        if (i == 2) {
          arri.a(2131692941);
        }
        while (i == 0) {
          return;
        }
        arri.a(2131694007);
        return;
      }
      localalqo.b(paramDataLineMsgRecord.strMoloKey);
      return;
    }
    paramDataLineMsgRecord = paramDataLineMsgRecord.path;
    arrr.a(this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity, paramDataLineMsgRecord);
  }
  
  private void a(dq paramdq, DataLineMsgRecord paramDataLineMsgRecord)
  {
    alqo localalqo = (alqo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramDataLineMsgRecord.strMoloKey != null) {
      localalqo.b(111);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramDataLineMsgRecord.sessionid));
    if (localalqo.a(localArrayList))
    {
      paramdq.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_Int = 3;
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).c(paramDataLineMsgRecord.msgId);
      paramDataLineMsgRecord.issuc = true;
      return;
    }
    arri.a(2131694064);
  }
  
  private void b(dq paramdq, DataLineMsgRecord paramDataLineMsgRecord)
  {
    alqo localalqo = (alqo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramdq.jdField_a_of_type_Int == 0) {
      localalqo.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 1, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
    for (;;)
    {
      paramdq.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_Int = 0;
      return;
      localalqo.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 0, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
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
        localObject = (ProgressBar)paramListView.findViewById(2131366314);
        if (localObject != null) {
          ((ProgressBar)localObject).setProgress((int)(f * 100.0F));
        }
        paramListView = (TextView)paramListView.findViewById(2131366344);
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
      dq localdq;
      if (paramView == null)
      {
        localdq = new dq(this);
        if (i != 0)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558972, null);
          localdq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365809));
          localdq.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = ((WaitTextView)paramView.findViewById(2131365811));
          paramView.setTag(localdq);
          if (i == 0) {
            break label519;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount() != this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) {
            break label331;
          }
          paramView.setVisibility(4);
          localdq.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
        }
      }
      do
      {
        return paramView;
        i = 0;
        break;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558971, null);
        localdq.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366329));
        localdq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        localdq.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localdq);
        localdq.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366302));
        localdq.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843829);
        localdq.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localdq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366339));
        localdq.b = ((TextView)paramView.findViewById(2131366343));
        localdq.c = ((TextView)paramView.findViewById(2131366344));
        localdq.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366314));
        localdq.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361886));
        localdq.jdField_a_of_type_AndroidWidgetButton.setTag(localdq);
        localdq.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break label88;
        localdq = (dq)paramView.getTag();
        break label94;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isTimeOut())
        {
          localdq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localdq.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
          paramInt = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
          i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
          paramViewGroup = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694055), new Object[] { Integer.valueOf(i - paramInt) });
          localdq.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText(paramViewGroup);
          localdq.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.a();
          return paramView;
        }
        localdq.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
        localdq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localdq.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
        paramInt = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
        i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
        paramViewGroup = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694053), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i - paramInt) });
        localdq.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText(paramViewGroup);
        return paramView;
        if (paramViewGroup == null)
        {
          localdq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localdq.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
          return paramView;
        }
        localdq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localdq.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        localdq.jdField_a_of_type_ComDatalineUtilFileDLFileInfo = a(paramViewGroup);
        localdq.jdField_a_of_type_Int = paramViewGroup.msgtype;
        if ((paramViewGroup.strMoloKey != null) && (paramViewGroup.bIsApkFile))
        {
          localdq.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843829);
          localdq.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramViewGroup.strMoloIconUrl);
        }
        for (;;)
        {
          localdq.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.filename);
          localdq.b.setText(ey.a(paramViewGroup.filesize));
          if ((paramViewGroup.progress != 1.0F) && (paramViewGroup.issuc) && (paramViewGroup.fileMsgStatus != 1L) && (paramViewGroup.fileMsgStatus != 2L)) {
            break label806;
          }
          localdq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localdq.c.setVisibility(4);
          if ((paramViewGroup.issuc) && (paramViewGroup.fileMsgStatus != 1L) && (paramViewGroup.fileMsgStatus != 2L)) {
            break;
          }
          localdq.jdField_a_of_type_AndroidWidgetButton.setText(2131694065);
          return paramView;
          arrr.a(localdq.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramViewGroup);
        }
      } while (paramViewGroup.progress != 1.0F);
      if ((paramViewGroup.strMoloKey == null) || (!paramViewGroup.bIsApkFile) || (paramViewGroup.nAppStatus == 1))
      {
        localdq.jdField_a_of_type_AndroidWidgetButton.setText(2131694052);
        return paramView;
      }
      localdq.jdField_a_of_type_AndroidWidgetButton.setText(2131694034);
      return paramView;
      localdq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localdq.c.setVisibility(0);
      paramInt = (int)(paramViewGroup.progress * 100.0F);
      localdq.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      localdq.c.setText(String.valueOf(paramInt) + "%");
      localdq.jdField_a_of_type_AndroidWidgetButton.setText(2131694056);
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dm
 * JD-Core Version:    0.7.0.1
 */