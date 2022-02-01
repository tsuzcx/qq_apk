package com.tencent.mobileqq.troop.filemanager.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Map;

public class TroopFileItem
{
  protected int a;
  protected long a;
  protected Context a;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  protected View a;
  protected CheckBox a;
  protected ImageView a;
  protected TextView a;
  protected QQAppInterface a;
  protected QQFileManagerUtil.TipsClickedInterface a;
  protected AsyncImageView a;
  protected TroopFileInfo a;
  protected TroopFileItemOperation a;
  private TroopFileItem.OnItemSelectedListener jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileItem$OnItemSelectedListener;
  protected EllipsizingTextView a;
  protected CircleFileStateView a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  protected View.OnClickListener b;
  protected View b;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public TroopFileItem(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379384);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379389));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379390));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379387));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379388));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379385));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131366794));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation = new TroopFileItemOperation(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    a();
    this.jdField_a_of_type_JavaLangString = "";
    b();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramLong *= 1000L;
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    if (paramLong <= l) {
      return paramContext.getString(2131697337);
    }
    paramLong = (paramLong - l) / 86400000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong + 1L);
    localStringBuilder.append(paramContext.getString(2131697310));
    return localStringBuilder.toString();
  }
  
  private final void a(boolean paramBoolean, int paramInt)
  {
    CircleFileStateView localCircleFileStateView = this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localCircleFileStateView.setVisibility(i);
    if (paramInt == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(paramInt);
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(HardCodeUtil.a(2131715119));
    } else if (paramInt == 3) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(HardCodeUtil.a(2131715099));
    } else if (paramInt == 2) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(HardCodeUtil.a(2131715100));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription("");
    }
    long l4 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_d_of_type_Long;
    long l2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Long;
    long l1 = l4;
    long l3 = l2;
    if (l4 > l2)
    {
      l1 = l2;
      l3 = l2;
    }
    while (l3 > 2147483647L)
    {
      l3 >>= 1;
      l1 >>= 1;
    }
    double d1 = l1;
    Double.isNaN(d1);
    double d2 = l3;
    Double.isNaN(d2);
    paramInt = (int)(d1 * 100.0D / d2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress(paramInt);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(6, -1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(8, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(9, 2);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(10, 2);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(11, -1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(7, -1);
  }
  
  protected TroopFileInfo a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if (paramView != null)
    {
      if (!(paramView instanceof TroopFileInfo)) {
        return null;
      }
      return (TroopFileInfo)paramView;
    }
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopFileItem.1(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new TroopFileItem.2(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopFileItem.3(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilQQFileManagerUtil$TipsClickedInterface = new TroopFileItem.4(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    if (localObject1 == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo);
    paramContext.getResources();
    this.c = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_d_of_type_Boolean;
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_c_of_type_JavaLangString;
    if (!this.c)
    {
      if (!paramBoolean)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
        if ((localObject1 != null) && (((TroopFileInfo)localObject1).j == null)) {
          paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_JavaUtilUUID, 128);
        }
      }
      if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.j))
      {
        i = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_c_of_type_JavaLangString);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.j, i);
      }
      else
      {
        i = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(HardCodeUtil.a(2131715126));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844366);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(HardCodeUtil.a(2131715142));
    }
    Object localObject2;
    if (!this.c)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a();
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.m;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        paramQQAppInterface = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697376), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_JavaUtilMap.size()) });
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.h < 0) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.h = 0;
        }
        paramQQAppInterface = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697339), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.h) });
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.n;
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692346));
      ((StringBuilder)localObject3).append(paramQQAppInterface);
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
      localObject3 = "";
      paramQQAppInterface = (QQAppInterface)localObject3;
      localObject2 = paramQQAppInterface;
      localObject1 = paramQQAppInterface;
      paramQQAppInterface = (QQAppInterface)localObject3;
    }
    if (this.jdField_d_of_type_Boolean) {
      paramQQAppInterface = "";
    }
    Object localObject4 = null;
    localObject3 = localObject4;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_c_of_type_Int != 0)
    {
      localObject3 = localObject4;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_Int != 102) {
        localObject3 = a(paramContext, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_c_of_type_Int);
      }
    }
    if (TroopFileInfo.FileStatus.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e)) {}
    while (this.jdField_d_of_type_Boolean)
    {
      i = 0;
      break;
    }
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e != 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e != 8) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e != 9)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e != 11) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e != 6)) {
      c(false);
    } else if (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.i)) {
      c(true);
    } else {
      c(false);
    }
    a(paramBoolean, this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.e, -1));
    if (i == 0) {
      paramQQAppInterface = "";
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_b_of_type_Boolean);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject1, paramQQAppInterface, (String)localObject2, (String)localObject3, this.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilQQFileManagerUtil$TipsClickedInterface);
  }
  
  public void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    TroopFileInfo localTroopFileInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    if (localTroopFileInfo == null) {
      return;
    }
    if (!localTroopFileInfo.jdField_d_of_type_Boolean)
    {
      localTroopFileInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
      if ((localTroopFileInfo != null) && (localTroopFileInfo.j == null)) {
        TroopFileTransferManager.a(paramQQAppInterface, paramLong).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_JavaUtilUUID, 128);
      }
    }
  }
  
  protected void a(View paramView)
  {
    TroopFileInfo localTroopFileInfo = a(paramView.findViewById(2131379385));
    if (localTroopFileInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (!localTroopFileInfo.jdField_d_of_type_Boolean) {
        if (this.jdField_b_of_type_Boolean)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileItem$OnItemSelectedListener;
          if (paramView != null) {
            paramView.a(false, localTroopFileInfo);
          }
        }
        else
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileItem$OnItemSelectedListener;
          if (paramView != null) {
            paramView.a(true, localTroopFileInfo);
          }
        }
      }
    }
    else
    {
      if (!localTroopFileInfo.jdField_d_of_type_Boolean)
      {
        switch (localTroopFileInfo.e)
        {
        case 4: 
        case 5: 
        default: 
          return;
        case 13: 
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.f(localTroopFileInfo);
          return;
        case 12: 
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(localTroopFileInfo, this.jdField_a_of_type_AndroidContentContext.getString(2131697770), this.jdField_a_of_type_AndroidContentContext.getString(2131697771));
          return;
        }
        TroopFileStatusInfo localTroopFileStatusInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(localTroopFileInfo);
        int i = FileManagerUtil.a(localTroopFileStatusInfo.g);
        if ((i != 0) && (i != 2))
        {
          QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, localTroopFileStatusInfo, String.valueOf(localTroopFileInfo.jdField_b_of_type_Long), localTroopFileInfo.jdField_c_of_type_Int, this.jdField_a_of_type_Int, false);
          return;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(localTroopFileInfo);
        paramView = QFileUtils.a(paramView.findViewById(2131379389), localTroopFileInfo.jdField_c_of_type_JavaLangString);
        QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Long, localTroopFileStatusInfo, String.valueOf(localTroopFileInfo.jdField_b_of_type_Long), localTroopFileInfo.jdField_c_of_type_Int, i, this.jdField_a_of_type_Int, paramView, false, false);
        return;
      }
      paramView = new Intent();
      paramView.putExtra(TeamWorkConstants.e, this.jdField_a_of_type_Long);
      paramView.putExtra("folderPath", localTroopFileInfo.jdField_b_of_type_JavaLangString);
      paramView.putExtra("folderName", localTroopFileInfo.jdField_c_of_type_JavaLangString);
      paramView.putExtra("param_from", 2000);
      TroopFileProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getId() != 2131379385) {
      paramView = paramView.findViewById(2131379385);
    }
    if ((paramView != null) && ((paramView instanceof CircleFileStateView))) {
      ((CircleFileStateView)paramView).setState(paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    TroopFileInfo localTroopFileInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    if (localTroopFileInfo != null) {
      TextUtils.isEmpty(localTroopFileInfo.a(paramQQAppInterface, paramLong));
    }
  }
  
  public void a(TroopFileItem.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileItem$OnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected boolean a(View paramView)
  {
    return false;
  }
  
  public void b(long paramLong, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    if (paramQQAppInterface == null) {
      return;
    }
    if (!paramQQAppInterface.jdField_d_of_type_Boolean)
    {
      if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.j))
      {
        i = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_c_of_type_JavaLangString);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.j, i);
        return;
      }
      int i = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
    }
  }
  
  protected void b(View paramView)
  {
    TroopFileInfo localTroopFileInfo = a(paramView);
    if (localTroopFileInfo == null) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    switch (localTroopFileInfo.e)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 13: 
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.f(localTroopFileInfo);
      a(paramView, 1);
      return;
    case 12: 
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(localTroopFileInfo, this.jdField_a_of_type_AndroidContentContext.getString(2131697770), this.jdField_a_of_type_AndroidContentContext.getString(2131697771));
      a(paramView, 2);
      return;
    case 10: 
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.d(localTroopFileInfo);
      a(paramView, 2);
      return;
    case 9: 
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.b(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
      return;
    case 8: 
      localTroopFileTransferManager.d(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
      a(paramView, 2);
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(localTroopFileInfo.jdField_b_of_type_JavaLangString, localTroopFileInfo.jdField_c_of_type_JavaLangString, localTroopFileInfo.jdField_a_of_type_Long, localTroopFileInfo.jdField_a_of_type_Int);
      a(paramView, 2);
      return;
    case 6: 
    case 11: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(localTroopFileInfo);
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(localTroopFileInfo);
      QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Long, paramView, String.valueOf(localTroopFileInfo.jdField_b_of_type_Long), localTroopFileInfo.jdField_c_of_type_Int, i, this.jdField_a_of_type_Int, null, false, false);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.c(localTroopFileInfo);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    localTroopFileTransferManager.a(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
    a(paramView, 3);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected void c(View paramView)
  {
    paramView = a((TextView)paramView.findViewById(2131379387));
    if (paramView == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    localIntent.putExtra("filter_member_name", paramView.c());
    localIntent.putExtra("filter_uin", paramView.jdField_b_of_type_Long);
    localIntent.putExtra("folderPath", "/");
    localIntent.putExtra("param_from", 4000);
    TroopFileProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131692347);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileItem
 * JD-Core Version:    0.7.0.1
 */