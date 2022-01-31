import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter.1;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.image.URLImageView;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;

public class fk
  extends gm
{
  private int jdField_a_of_type_Int;
  protected Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected LiteActivity a;
  protected QQAppInterface a;
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c = -1;
  
  public fk(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fl(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296692);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296691);
    b();
  }
  
  private Drawable a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    boolean bool = paramDataLineMsgRecord.isSendFromLocal();
    int i;
    if ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009))
    {
      i = 1;
      if (i != 0) {
        break label40;
      }
      paramDataLineMsgRecord = null;
    }
    for (;;)
    {
      return paramDataLineMsgRecord;
      i = 0;
      break;
      label40:
      Drawable localDrawable;
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        paramDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
        localDrawable = paramDataLineMsgRecord.getDrawable(2130848940);
        paramDataLineMsgRecord = paramDataLineMsgRecord.getDrawable(2130848764);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDataLineMsgRecord;
      }
      while (bool)
      {
        return localDrawable;
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramDataLineMsgRecord = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      }
    }
  }
  
  private void a(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (paramDrawable == null)
    {
      paramView.setBackgroundDrawable(null);
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i = paramView.getPaddingTop();
    int j = localRect.top;
    int k = paramView.getPaddingLeft();
    int m = localRect.left;
    int n = paramView.getPaddingRight();
    int i1 = localRect.right;
    int i2 = paramView.getPaddingBottom();
    int i3 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(k + m, i + j, n + i1, i3 + i2);
  }
  
  private void a(GridView paramGridView)
  {
    int i = (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getWindowManager().getDefaultDisplay().getWidth() - actj.a(147.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()) - 2) / 3;
    paramGridView.setNumColumns(3);
    paramGridView.setColumnWidth(i);
    paramGridView.setHorizontalSpacing(1);
    paramGridView.setSelector(new ColorDrawable(0));
    paramGridView.setTag(Integer.valueOf(i));
    paramGridView.setClickable(true);
    paramGridView.setLongClickable(true);
    paramGridView.setAddStatesFromChildren(true);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = aqcg.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10006);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), TroopFileDetailBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("forward_from_troop_file", true);
    localIntent.putExtra("not_forward", true);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(localIntent, 102);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, RelativeLayout paramRelativeLayout, fw paramfw)
  {
    Object localObject;
    if ((paramDataLineMsgRecord.vipBubbleID == 100000L) && (paramDataLineMsgRecord.msgtype == -1000))
    {
      localObject = lbn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localObject = lbj.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(paramDataLineMsgRecord.msg, paramDataLineMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((lbi)localObject).a().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal()))
      {
        paramfw.jdField_a_of_type_Ambg = amcg.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
        if (paramfw.jdField_a_of_type_Ambg != null)
        {
          paramfw.jdField_a_of_type_Ambg.a(paramRelativeLayout, null);
          if (paramDataLineMsgRecord.msgtype == -1000) {
            break label333;
          }
        }
      }
    }
    label333:
    for (boolean bool = true;; bool = false)
    {
      int i = paramDataLineMsgRecord.vipBubbleDiyTextId;
      if (i <= 0) {
        akfv.b(paramDataLineMsgRecord.vipBubbleID);
      }
      paramfw.jdField_a_of_type_Ambg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, ho.a(paramDataLineMsgRecord), i);
      if ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009) || (paramDataLineMsgRecord.msgtype == -2009))
      {
        localObject = a(paramDataLineMsgRecord);
        if (localObject != null) {
          a(paramRelativeLayout, (Drawable)localObject);
        }
      }
      if (paramDataLineMsgRecord.msgtype == -2000) {
        a(paramRelativeLayout, null);
      }
      if (paramDataLineMsgRecord.msgtype == -1000) {
        a(paramfw, paramRelativeLayout, paramDataLineMsgRecord, paramfw.jdField_a_of_type_Ambg);
      }
      a(paramRelativeLayout, paramDataLineMsgRecord);
      return;
      paramfw.jdField_a_of_type_Ambg = amcg.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
      paramfw.jdField_a_of_type_Ambg = amcg.a(((akfv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramDataLineMsgRecord), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
    }
  }
  
  private void a(fw paramfw, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837914), paramInt1, paramInt2, false);
        Object localObject1 = bbef.a(localBitmap, actj.a(12.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()));
        localObject3 = localObject1;
        if (localBitmap != null) {}
        localObject3 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localBitmap.recycle();
          localObject3 = localObject1;
          if (localObject3 == null) {
            break;
          }
          localObject1 = new ClipDrawable(new BitmapDrawable(localObject3), 48, 2);
          paramfw.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject3;
          Object localObject2;
          break label104;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject2 = null;
      }
      label104:
      if (QLog.isColorLevel())
      {
        QLog.e("DatalineSessionAdapter", 2, "DataLineSessionAdapter OOM");
        localObject3 = localObject2;
      }
    }
    paramfw.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(null);
  }
  
  private boolean a(fw paramfw, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramfw == null) {}
    do
    {
      return true;
      if (paramfw.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        return false;
      }
    } while (paramDataLineMsgSet == null);
    int i = paramDataLineMsgSet.getCompletedCount();
    int j = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    if ((paramDataLineMsgSet.getAt(0) != null) && (paramDataLineMsgSet.getAt(0).strMoloIconUrl != null))
    {
      paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
      if ((paramDataLineMsgSet.getTotalCount() < 2) || (paramDataLineMsgSet.getAt(1) == null) || (paramDataLineMsgSet.getAt(1).strMoloIconUrl == null)) {
        break label492;
      }
      paramfw.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
      label128:
      if ((paramDataLineMsgSet.getTotalCount() < 3) || (paramDataLineMsgSet.getAt(2) == null) || (paramDataLineMsgSet.getAt(2).strMoloIconUrl == null)) {
        break label508;
      }
      paramfw.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
      label173:
      if ((paramDataLineMsgSet.getTotalCount() < 4) || (paramDataLineMsgSet.getAt(3) == null) || (paramDataLineMsgSet.getAt(3).strMoloIconUrl == null)) {
        break label524;
      }
      paramfw.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
      label218:
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setText(apug.d(paramDataLineMsgSet.getFileNames()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (!localDataLineMsgRecord.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131693973)))) {
        break label540;
      }
      paramfw.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label298:
      paramfw.a().jdField_c_of_type_AndroidWidgetTextView.setText(gp.a(paramDataLineMsgSet.getFileTotalSize()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
        break label578;
      }
      paramfw.a().e.setText(localDataLineMsgRecord.strMoloSource);
      paramfw.a().e.setVisibility(0);
      paramfw.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label374:
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label593;
      }
      paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label422:
      if (!paramDataLineMsgSet.isCanceled()) {
        break label608;
      }
      paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693939);
    }
    for (;;)
    {
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label709;
      }
      paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
      paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843405);
      break;
      label492:
      paramfw.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843405);
      break label128;
      label508:
      paramfw.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843405);
      break label173;
      label524:
      paramfw.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843405);
      break label218;
      label540:
      paramfw.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramfw.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693877);
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label298;
      label578:
      paramfw.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label374;
      label593:
      paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label422;
      label608:
      if (paramDataLineMsgSet.isFileComing()) {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692488);
      } else if (i == j) {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText("" + j);
      } else {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "/" + j);
      }
    }
    label709:
    paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = aqcg.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10002);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("not_forward", true);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(localIntent, 102);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() == 0);
  }
  
  private boolean b(fw paramfw, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramfw == null) {
      return true;
    }
    if (paramfw.a().jdField_a_of_type_AndroidWidgetTextView == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int i = paramDataLineMsgSet.getCompletedCount();
    int j = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    fp localfp;
    label148:
    label313:
    if (i == j)
    {
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setText("" + j);
      i = ((Integer)paramfw.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
      localfp = (fp)paramfw.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
      if (localfp != null) {
        break label401;
      }
      localfp = new fp(this, paramfw, paramDataLineMsgSet, i, null);
      paramfw.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter(localfp);
      paramfw.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramDataLineMsgSet.printlog();
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label455;
      }
      paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (!paramDataLineMsgSet.isCanceled()) {
        break label421;
      }
      paramfw.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramfw.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693939);
      label227:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramfw.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label488;
          }
          paramfw.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramfw.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramfw.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label503;
          }
          paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      return true;
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setText(i + "/" + j);
      break;
      label401:
      localfp.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      localfp.jdField_a_of_type_Fw = paramfw;
      localfp.a();
      break label148;
      label421:
      if (!paramDataLineMsgSet.isFileComing()) {
        break label227;
      }
      paramfw.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramfw.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131692488);
      break label227;
      label455:
      paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
      break label227;
      label488:
      paramfw.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label313;
      label503:
      paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void c(fw paramfw, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramfw == null) {}
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    } while (localDataLineMsgRecord == null);
    paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
    paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
    paramfw.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    label316:
    if ((localDataLineMsgRecord.path != null) && (new VFSFile(localDataLineMsgRecord.path).exists()))
    {
      paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.path);
      label124:
      if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        break label482;
      }
      paramfw.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus != 1L) || (localDataLineMsgRecord.thumbPath != null)) {
        break label467;
      }
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setText(2131693892);
      label230:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramfw.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label540;
          }
          paramfw.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramfw.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramfw.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label555;
          }
          paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        paramfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajya.a(2131702759));
      }
      if (paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        break;
      }
      paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(ajya.a(2131702751));
      return;
      if ((localDataLineMsgRecord.thumbPath != null) && (localDataLineMsgRecord.thumbPath.length() > 0))
      {
        paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        break label124;
      }
      paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
      break label124;
      label467:
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label230;
      label482:
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramfw.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        int i = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramfw.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i);
        break label230;
      }
      paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break label230;
      label540:
      paramfw.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label316;
      label555:
      paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void d(fw paramfw, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramfw == null) {}
    while (paramDataLineMsgSet == null) {
      return;
    }
    paramfw.jdField_a_of_type_AndroidWidgetImageView.setTag(paramfw);
    if ((paramDataLineMsgSet.isSendFromLocal()) && (paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramfw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    paramfw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramDataLineMsgSet.getOpType() == 1)
    {
      paramfw.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      return;
    }
    paramfw.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public long a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getTime();
  }
  
  protected View a(int paramInt, fw paramfw, DataLineMsgSet paramDataLineMsgSet)
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = false;
    new Handler().postDelayed(new DatalineSessionAdapter.1(this), 1500L);
  }
  
  protected void a(int paramInt, fw paramfw, DataLineMsgSet paramDataLineMsgSet) {}
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    Object localObject = null;
    if (paramListView == null) {}
    int i;
    DataLineMsgSet localDataLineMsgSet;
    int j;
    label168:
    label379:
    do
    {
      float f;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
              } while (i == -1);
              paramListView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
            } while ((paramListView == null) || (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()));
            localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i);
            if (localDataLineMsgSet.mUpdateProcessTick == 0L) {}
            for (localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();; localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis())
            {
              if (!localDataLineMsgSet.isSingle()) {
                break label379;
              }
              j = DataLineMsgRecord.getDevTypeBySeId(paramLong);
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j).a(paramLong);
              if (localObject == null) {
                break;
              }
              if (!a(getItemViewType(i))) {
                break label168;
              }
              a((DataLineMsgRecord)localObject, paramListView, paramFloat);
              return;
              if (System.currentTimeMillis() - localDataLineMsgSet.mUpdateProcessTick < 1000L) {
                break;
              }
            }
            f = paramFloat;
            if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
              f = ((DataLineMsgRecord)localObject).progress;
            }
            switch (((DataLineMsgRecord)localObject).msgtype)
            {
            default: 
              return;
            case -2335: 
            case -2009: 
            case -2005: 
              if (!((DataLineMsgRecord)localObject).bIsMoloImage) {
                break label272;
              }
              paramListView = (MessageProgressTextView)paramListView.findViewById(2131367791);
            }
          } while (paramListView == null);
          paramListView.setProgress((int)(f * 100.0F));
          return;
          localObject = (TextView)paramListView.findViewById(2131366254);
          paramListView = (ProgressBar)paramListView.findViewById(2131366224);
          if (paramListView != null)
          {
            paramListView.setVisibility(0);
            paramListView.setProgress((int)(f * 100.0F));
          }
        } while (localObject == null);
        ((TextView)localObject).setText((int)(f * 100.0F) + "%");
        return;
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131367791);
      } while (paramListView == null);
      paramListView.setProgress((int)(f * 100.0F));
      return;
      paramListView = (fw)paramListView.getTag();
    } while (paramListView == null);
    label272:
    switch (localDataLineMsgSet.getGroupType())
    {
    default: 
      paramListView = null;
      label442:
      i = localDataLineMsgSet.getCompletedCount();
      j = localDataLineMsgSet.getTotalCount();
      if (localObject != null)
      {
        if (i != j) {
          break label542;
        }
        ((TextView)localObject).setText("" + j);
      }
      break;
    }
    while (paramListView != null)
    {
      if (i != j) {
        break label576;
      }
      paramListView.setVisibility(4);
      return;
      localObject = paramListView.a().jdField_d_of_type_AndroidWidgetTextView;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label442;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label442;
      label542:
      ((TextView)localObject).setText(i + "/" + j);
    }
    label576:
    paramListView.setVisibility(0);
    paramListView.setProgress((int)(localDataLineMsgSet.getTotalProcess() * 100.0F));
  }
  
  protected void a(View paramView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, BaseChatItemLayout.i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat) {}
  
  public void a(DataLineMsgSetList paramDataLineMsgSetList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
  }
  
  protected void a(fw paramfw, View paramView, DataLineMsgRecord paramDataLineMsgRecord, ambg paramambg)
  {
    if (paramambg == null) {
      return;
    }
    if ((paramambg.jdField_a_of_type_Int == 0) || (!paramambg.a()))
    {
      paramambg = paramView.getResources();
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramView = paramambg.getColorStateList(2131166876);
        paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (!paramDataLineMsgRecord.isSendFromLocal()) {
          break label95;
        }
      }
      label95:
      for (paramView = paramambg.getColorStateList(2131166875);; paramView = paramambg.getColorStateList(2131166874))
      {
        paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView);
        return;
        paramView = paramambg.getColorStateList(2131166872);
        break;
      }
    }
    if (paramambg.jdField_b_of_type_Int == 0) {
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramambg.c == 0)
    {
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131166874));
      return;
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambg.jdField_b_of_type_Int);
    }
    paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramambg.c);
  }
  
  protected void a(fw paramfw, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramfw == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
    apug.a(paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramDataLineMsgSet);
    paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setText(apug.d(paramDataLineMsgSet.filename));
    paramfw.a().jdField_c_of_type_AndroidWidgetTextView.setText(gp.a(paramDataLineMsgSet.filesize));
    if (paramDataLineMsgSet.isSendFromLocal()) {
      if (paramDataLineMsgSet.fileMsgStatus == 2L) {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693939);
      }
    }
    while ((paramDataLineMsgSet.progress == 1.0F) || (!paramDataLineMsgSet.issuc) || (paramDataLineMsgSet.fileMsgStatus == 1L) || (paramDataLineMsgSet.fileMsgStatus == 2L))
    {
      paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692487);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692485);
        } else {
          paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692486);
        }
      }
      else
      {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        continue;
        if (paramDataLineMsgSet.fileMsgStatus == 2L) {
          paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693939);
        } else if (paramDataLineMsgSet.fileMsgStatus == 1L) {
          paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692488);
        } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
          paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692479);
        } else if (!paramDataLineMsgSet.issuc) {
          paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692485);
        } else {
          paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        }
      }
    }
    paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(long paramLong, ListView paramListView)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).b(paramLong);
    if (b()) {
      return false;
    }
    if (paramListView == null) {
      return true;
    }
    i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
    if (i == -1) {
      return false;
    }
    View localView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
    if (localView == null) {
      return false;
    }
    if (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) {
      return false;
    }
    paramListView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i);
    if ((localObject != null) && (((DataLineMsgRecord)localObject).fileMsgStatus == 1L)) {
      if (paramListView.mUpdateMutiViewTick != 0L) {
        break label138;
      }
    }
    for (paramListView.mUpdateMutiViewTick = System.currentTimeMillis(); paramListView.isSingle(); paramListView.mUpdateMutiViewTick = System.currentTimeMillis())
    {
      return true;
      label138:
      if (System.currentTimeMillis() - paramListView.mUpdateMutiViewTick < 1000L) {
        return true;
      }
    }
    localObject = (fw)localView.getTag();
    if (localObject == null) {
      return false;
    }
    switch (paramListView.getGroupType())
    {
    }
    do
    {
      do
      {
        do
        {
          d((fw)localObject, paramListView);
          return true;
          if (!paramListView.getFirstItem().bIsMoloImage) {
            break;
          }
        } while (b((fw)localObject, paramListView));
        return false;
      } while (a((fw)localObject, paramListView));
      return false;
    } while (b((fw)localObject, paramListView));
    return false;
  }
  
  public long b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getMsgId();
  }
  
  protected void b(fw paramfw, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramfw == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    if (paramDataLineMsgSet.strMoloIconUrl != null)
    {
      paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setText(apug.d(paramDataLineMsgSet.filename));
      if ((paramDataLineMsgSet.strMoloSource == null) || (!paramDataLineMsgSet.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131693973)))) {
        break label333;
      }
      paramfw.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label127:
      paramfw.a().jdField_c_of_type_AndroidWidgetTextView.setText(gp.a(paramDataLineMsgSet.filesize));
      if ((paramDataLineMsgSet.strMoloSource == null) || (paramDataLineMsgSet.strMoloSource.equals(""))) {
        break label371;
      }
      paramfw.a().e.setText(paramDataLineMsgSet.strMoloSource);
      paramfw.a().e.setVisibility(0);
      paramfw.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label200:
      if ((paramDataLineMsgSet.strMoloSrcIconUrl == null) || (paramDataLineMsgSet.strMoloSrcIconUrl.equals(""))) {
        break label386;
      }
      paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label245:
      if (paramDataLineMsgSet.fileMsgStatus != 2L) {
        break label401;
      }
      paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693939);
    }
    for (;;)
    {
      if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L)) {
        break label514;
      }
      paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      paramfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843405);
      break;
      label333:
      paramfw.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramfw.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693877);
      paramfw.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label127;
      label371:
      paramfw.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label200;
      label386:
      paramfw.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label245;
      label401:
      if (paramDataLineMsgSet.fileMsgStatus == 1L) {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692488);
      } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692479);
      } else if (!paramDataLineMsgSet.issuc) {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692485);
      } else {
        paramfw.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
      }
    }
    label514:
    paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
  }
  
  public int getCount()
  {
    if (b()) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (b()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 1;
    if (b()) {
      paramInt = 13;
    }
    label137:
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      DataLineMsgSet localDataLineMsgSet;
      boolean bool;
      do
      {
        return paramInt;
        localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
        bool = localDataLineMsgSet.isSendFromLocal();
        switch (localDataLineMsgSet.getGroupType())
        {
        default: 
          return 12;
        case -1000: 
          if (bool) {
            return 7;
          }
          return 0;
        case -2000: 
          if (!localDataLineMsgSet.isSingle()) {
            break label137;
          }
          paramInt = i;
        }
      } while (!bool);
      return 8;
      if (bool) {
        return 9;
      }
      return 2;
      if (localDataLineMsgSet.isSingle())
      {
        if (bool) {
          return 10;
        }
        return 3;
      }
      if (bool) {
        return 11;
      }
      return 4;
      localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
      if (!localDataLineMsgSet.isSingle()) {
        break;
      }
      paramInt = i;
    } while (localDataLineMsgRecord.bIsMoloImage);
    return 5;
    if (localDataLineMsgRecord.bIsMoloImage) {
      return 2;
    }
    return 6;
    return 14;
    return 15;
    return 16;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (b())
    {
      if (paramView == null)
      {
        paramViewGroup = new fw();
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558962, null);
        localObject1 = (TextView)paramView.findViewById(2131369330);
        localObject2 = (ImageView)paramView.findViewById(2131369329);
        if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Int == 1)
        {
          ((TextView)localObject1).setText(2131691382);
          ((ImageView)localObject2).setImageResource(2130839280);
        }
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramView.setVisibility(4);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.t();
        localObject1 = paramView;
        return localObject1;
        paramViewGroup = (fw)paramView.getTag();
      }
    }
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.t();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
    if (localObject2 == null) {
      return null;
    }
    paramInt = getItemViewType(paramInt);
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgSet)localObject2).getFirstItem();
    if (paramView == null)
    {
      localObject1 = new fw();
      if (a(paramInt))
      {
        paramView = a(paramInt, (fw)localObject1, (DataLineMsgSet)localObject2);
        label184:
        paramView.setTag(localObject1);
      }
    }
    Object localObject3;
    int i;
    for (paramViewGroup = (ViewGroup)localObject1;; paramViewGroup = (fw)paramView.getTag())
    {
      paramViewGroup.a((DataLineMsgSet)localObject2);
      localObject1 = paramView;
      if (paramInt == 12) {
        break;
      }
      if (paramInt != 14) {
        break label3079;
      }
      localObject1 = paramView;
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break;
      }
      localObject2 = (anoy)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361805);
      localObject1 = paramView;
      if (localObject2 == null) {
        break;
      }
      paramInt = acur.a(((anoy)localObject2).getBitmap());
      paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.valueOf(paramInt));
      return paramView;
      if (paramInt == 12)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558950, null);
        ((fw)localObject1).b((TextView)paramViewGroup.findViewById(2131364918));
        paramView = paramViewGroup;
        if (((fw)localObject1).b() == null) {
          break label184;
        }
        ((fw)localObject1).b().setText(2131693930);
        paramView = paramViewGroup;
        break label184;
      }
      Object localObject4;
      if (paramInt == 14)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558937, null);
        paramViewGroup = ((fw)localObject1).a();
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367153));
        localObject3 = ajya.a(2131702770);
        localObject4 = ajya.a(2131702747);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        localObject4 = new SpannableString("还想把文件发到好友手机？快来用\n" + (String)localObject3 + (String)localObject4);
        ((SpannableString)localObject4).setSpan(new fm(this), "还想把文件发到好友手机？快来用\n".length(), "还想把文件发到好友手机？快来用\n".length() + ((String)localObject3).length(), 33);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label184;
      }
      if (paramInt == 15)
      {
        paramViewGroup = ((fw)localObject1).a();
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560512, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367153));
        break label184;
      }
      if (paramInt == 16)
      {
        paramViewGroup = ((fw)localObject1).a();
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558782, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367153));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView.getResources().getColorStateList(2131165359));
        break label184;
      }
      if (!((DataLineMsgSet)localObject2).isSendFromLocal())
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558951, null);
        localObject3 = (ImageView)paramViewGroup.findViewById(2131367679);
        paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843409);
        i = DataLineMsgRecord.getDevTypeBySet((DataLineMsgSet)localObject2);
        if (i == 0)
        {
          paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843409);
          label691:
          ((ImageView)localObject3).setImageDrawable(paramView);
          paramView = paramViewGroup;
          label699:
          ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370477));
          ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
          ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
          ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
          ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
          ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        ((fw)localObject1).a((ImageView)paramView.findViewById(2131365723));
        ((fw)localObject1).a((TextView)paramView.findViewById(2131364919));
        break;
        if (i != 1) {
          break label691;
        }
        paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843407);
        break label691;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558957, null);
        break label699;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558958, null);
        ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377032));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject1);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setSpannableFactory(aykk.a);
        if (((DataLineMsgSet)localObject2).isSendFromLocal()) {}
        for (paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166876);; paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872))
        {
          ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup);
          ((fw)localObject1).a((ProgressBar)paramView.findViewById(2131375882));
          if (((fw)localObject1).a() == null) {
            break;
          }
          ((fw)localObject1).a().setVisibility(8);
          break;
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558938, null);
        ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367776));
        ((fw)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131367791));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131374863));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376456));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364251));
        ((fw)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378504));
        if (!((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((fw)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378503));
          ((fw)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367712));
          ((fw)localObject1).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376339));
        }
        if (((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((fw)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
          a((fw)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          label1449:
          ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
          if (BaseBubbleBuilder.jdField_a_of_type_Boolean) {
            break label1574;
          }
          ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(true);
        }
        for (;;)
        {
          ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
          ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajya.a(2131702757));
          ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(ajya.a(2131702765));
          break;
          ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((fw)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
          break label1449;
          label1574:
          paramViewGroup = new adkk(2130706432, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a() * 12.0F);
          ((fw)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(paramViewGroup);
          i = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
          ((fw)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setDisplayInTextView(false, i, -1);
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558940, null);
        ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371638));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131371609));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366224));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376456));
        ((fw)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378504));
        if (!((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((fw)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378503));
          ((fw)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367712));
          ((fw)localObject1).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376339));
        }
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject1);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        a(((fw)localObject1).a().jdField_a_of_type_AndroidWidgetGridView);
        continue;
        localObject3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558933, null);
        ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3);
        if (ajwc.a() > 17.0F)
        {
          ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
          i = actj.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          paramViewGroup = (RelativeLayout)paramView.findViewById(2131366236);
          localObject4 = new RelativeLayout.LayoutParams(-1, i);
          ((RelativeLayout.LayoutParams)localObject4).addRule(10, 2131366239);
          ((RelativeLayout)localObject3).updateViewLayout(paramViewGroup, (ViewGroup.LayoutParams)localObject4);
          localObject3 = (AsyncImageView)paramView.findViewById(2131366212);
          ((AsyncImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject4 = new RelativeLayout.LayoutParams(i, i);
          ((RelativeLayout.LayoutParams)localObject4).addRule(9, 2131366236);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15, 2131366236);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131366249);
          ((TextView)localObject3).setGravity(16);
          localObject4 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131366212);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, 2131366236);
          ((RelativeLayout.LayoutParams)localObject4).addRule(10, 2131366236);
          ((RelativeLayout.LayoutParams)localObject4).setMargins(actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131366254);
          ((TextView)localObject3).setGravity(5);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, 2131366236);
          ((RelativeLayout.LayoutParams)localObject4).addRule(12, 2131366236);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((fw)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131366253);
          ((TextView)localObject3).setGravity(17);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, 2131366236);
          ((RelativeLayout.LayoutParams)localObject4).addRule(2, 2131366254);
          paramViewGroup.updateViewLayout((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          ((fw)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject3);
        }
        for (;;)
        {
          ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366224));
          ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130849630);
          ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          break;
          ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
          ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366212));
          ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366249));
          ((fw)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366253));
          ((fw)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366254));
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558931, null);
        ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366212));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366249));
        ((fw)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366227));
        ((fw)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366253));
        ((fw)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366254));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366224));
        ((fw)localObject1).a().e = ((TextView)paramView.findViewById(2131378503));
        ((fw)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367712));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376339));
        ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843404);
        ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        continue;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558939, null);
        ((fw)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366213));
        ((fw)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366214));
        ((fw)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366215));
        ((fw)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366216));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366249));
        ((fw)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366227));
        ((fw)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366253));
        ((fw)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366254));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366224));
        ((fw)localObject1).a().e = ((TextView)paramView.findViewById(2131378503));
        ((fw)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367712));
        ((fw)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376339));
        ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843405);
        ((fw)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843405);
        ((fw)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843405);
        ((fw)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843405);
        ((fw)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((fw)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((fw)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((fw)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
      }
    }
    label3079:
    if (paramInt == 15)
    {
      paramViewGroup = paramViewGroup.a();
      localObject1 = apug.a(localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_tips"), localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_link"), new fn(this, localDataLineMsgRecord));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
      return paramView;
    }
    if (paramInt == 16)
    {
      localObject1 = paramViewGroup.a();
      if ((localDataLineMsgRecord != null) && (!TextUtils.isEmpty(localDataLineMsgRecord.msg)) && (((gd)localObject1).jdField_a_of_type_AndroidWidgetTextView != null) && (localDataLineMsgRecord.msg.indexOf(ajya.a(2131702760)) >= 0))
      {
        paramViewGroup = apug.a(localDataLineMsgRecord.msg, ajya.a(2131702748), new fo(this, localDataLineMsgRecord));
        ((gd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
        ((gd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((gd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
        return paramView;
      }
    }
    switch (paramInt)
    {
    }
    while (a(paramInt))
    {
      a(paramInt, paramViewGroup, (DataLineMsgSet)localObject2);
      return paramView;
      paramViewGroup.a().jdField_a_of_type_JavaLangString = localDataLineMsgRecord.msg;
      paramViewGroup.a().jdField_a_of_type_Long = localDataLineMsgRecord.sessionid;
      localObject1 = paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView;
      localObject3 = ajsd.z;
      localObject3 = new aykk(localDataLineMsgRecord.msg, 13, 32, 6000);
      ((aykk)localObject3).a("biz_src_jc_aio");
      ((TextView)localObject1).setText((CharSequence)localObject3);
      ((TextView)localObject1).setVisibility(0);
      if (paramViewGroup.a() != null)
      {
        if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress == 1.0F)) {
          break label3475;
        }
        paramViewGroup.a().setVisibility(0);
      }
      for (;;)
      {
        ((TextView)localObject1).setTextSize(0, ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()));
        break;
        label3475:
        paramViewGroup.a().setVisibility(8);
      }
      c(paramViewGroup, (DataLineMsgSet)localObject2);
      continue;
      b(paramViewGroup, (DataLineMsgSet)localObject2);
      continue;
      a(paramViewGroup, (DataLineMsgSet)localObject2);
      continue;
      b(paramViewGroup, (DataLineMsgSet)localObject2);
      continue;
      a(paramViewGroup, (DataLineMsgSet)localObject2);
    }
    a(localDataLineMsgRecord, paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout, paramViewGroup);
    int j;
    int k;
    if (ThemeUtil.isDefaultTheme())
    {
      paramInt = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      i = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight();
      j = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop();
      k = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingBottom();
      if (!((DataLineMsgSet)localObject2).isSendFromLocal()) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), j, i, k);
      }
    }
    else
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject1 = (anoy)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361805);
        if (localObject1 != null)
        {
          paramInt = acur.a(((anoy)localObject1).getBitmap());
          paramViewGroup.a().setTextColor(ColorStateList.valueOf(paramInt));
        }
      }
      if (!a(((DataLineMsgSet)localObject2).getMsgId())) {
        break label3762;
      }
      localObject1 = bbkp.a(this.jdField_a_of_type_AndroidContentContext, 3, ((DataLineMsgSet)localObject2).getTime() * 1000L);
      paramViewGroup.a().setVisibility(0);
      paramViewGroup.a().setText((CharSequence)localObject1);
    }
    for (;;)
    {
      d(paramViewGroup, (DataLineMsgSet)localObject2);
      return paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt, j, i + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), k);
      break;
      label3762:
      paramViewGroup.a().setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 17;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    c();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineSessionAdapter", 2, " notifyDataSetChanged ---------->");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     fk
 * JD-Core Version:    0.7.0.1
 */