import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.dataline.activities.LiteActivity;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ed
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  public DataLineMsgSet a;
  public ek a;
  private AsyncImageView[] jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView = new AsyncImageView[3];
  private int b;
  
  private ed(dy paramdy, ek paramek, DataLineMsgSet paramDataLineMsgSet, int paramInt)
  {
    this.jdField_a_of_type_Ek = paramek;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramInt;
    b();
  }
  
  private void b()
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i] = new AsyncImageView(this.jdField_a_of_type_Dy.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.b));
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setAdjustViewBounds(false);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setDefaultImage(2130850821);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setIsDrawRound(false);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setAsyncClipSize(this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setTag(this.jdField_a_of_type_Ek);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setClickable(true);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setLongClickable(true);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnClickListener(this.jdField_a_of_type_Dy.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnLongClickListener(this.jdField_a_of_type_Dy.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnTouchListener(this.jdField_a_of_type_Dy.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setContentDescription(anvx.a(2131702235));
      i += 1;
    }
  }
  
  public void a()
  {
    int i = 0;
    if (i < 3)
    {
      AsyncImageView localAsyncImageView = this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i];
      localAsyncImageView.setTag(this.jdField_a_of_type_Ek);
      DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(i);
      if (localDataLineMsgRecord == null) {
        localAsyncImageView.setImageResource(2130850821);
      }
      for (;;)
      {
        i += 1;
        break;
        String str = aueq.c(localDataLineMsgRecord.path);
        if ((str != null) && (new VFSFile(str).exists())) {
          localAsyncImageView.setAsyncImage(str);
        } else if (localDataLineMsgRecord.thumbPath != null) {
          localAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        }
      }
    }
  }
  
  public int getCount()
  {
    return 3;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramInt >= 3) {
      localObject = null;
    }
    DataLineMsgRecord localDataLineMsgRecord;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[paramInt];
      ((AsyncImageView)localObject).setTag(this.jdField_a_of_type_Ek);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(paramInt);
      if (localDataLineMsgRecord != null) {
        break;
      }
      ((AsyncImageView)localObject).setImageResource(2130850821);
    }
    String str = aueq.c(localDataLineMsgRecord.path);
    if ((str != null) && (new VFSFile(str).exists())) {
      ((AsyncImageView)localObject).setAsyncImage(str);
    }
    for (;;)
    {
      break;
      if (localDataLineMsgRecord.thumbPath != null) {
        ((AsyncImageView)localObject).setAsyncImage(localDataLineMsgRecord.thumbPath);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ed
 * JD-Core Version:    0.7.0.1
 */