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

class dy
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  public DataLineMsgSet a;
  public ef a;
  private AsyncImageView[] jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView = new AsyncImageView[3];
  private int b;
  
  private dy(dt paramdt, ef paramef, DataLineMsgSet paramDataLineMsgSet, int paramInt)
  {
    this.jdField_a_of_type_Ef = paramef;
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
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i] = new AsyncImageView(this.jdField_a_of_type_Dt.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.b));
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setAdjustViewBounds(false);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setDefaultImage(2130850064);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setIsDrawRound(false);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setAsyncClipSize(this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setTag(this.jdField_a_of_type_Ef);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setClickable(true);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setLongClickable(true);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnClickListener(this.jdField_a_of_type_Dt.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnLongClickListener(this.jdField_a_of_type_Dt.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnTouchListener(this.jdField_a_of_type_Dt.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setContentDescription(alpo.a(2131703123));
      i += 1;
    }
  }
  
  public void a()
  {
    int i = 0;
    if (i < 3)
    {
      AsyncImageView localAsyncImageView = this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i];
      localAsyncImageView.setTag(this.jdField_a_of_type_Ef);
      DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(i);
      if (localDataLineMsgRecord == null) {
        localAsyncImageView.setImageResource(2130850064);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localDataLineMsgRecord.path != null) && (new VFSFile(localDataLineMsgRecord.path).exists())) {
          localAsyncImageView.setAsyncImage(localDataLineMsgRecord.path);
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
    if (paramInt >= 3) {
      paramView = null;
    }
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return paramView;
      paramViewGroup = this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[paramInt];
      paramViewGroup.setTag(this.jdField_a_of_type_Ef);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(paramInt);
      if (localDataLineMsgRecord == null)
      {
        paramViewGroup.setImageResource(2130850064);
        return paramViewGroup;
      }
      if ((localDataLineMsgRecord.path != null) && (new VFSFile(localDataLineMsgRecord.path).exists()))
      {
        paramViewGroup.setAsyncImage(localDataLineMsgRecord.path);
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (localDataLineMsgRecord.thumbPath == null);
    paramViewGroup.setAsyncImage(localDataLineMsgRecord.thumbPath);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dy
 * JD-Core Version:    0.7.0.1
 */