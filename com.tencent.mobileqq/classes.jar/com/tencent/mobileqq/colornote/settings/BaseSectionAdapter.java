package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseSectionAdapter
{
  private int jdField_a_of_type_Int;
  private BaseSectionAdapter.OnDataRefreshListener jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter$OnDataRefreshListener;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public BaseSectionAdapter(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  private void a(ColorNote paramColorNote, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AA80", "0X800AA80", ColorNoteUtils.b(this.jdField_a_of_type_Int), 0, String.valueOf(paramInt), "", "", "");
    int j = paramColorNote.getServiceType();
    boolean bool2 = false;
    int i = 0;
    paramInt = 1;
    if (j == 17039360)
    {
      String str;
      if ((!TextUtils.isEmpty(paramColorNote.getSubType())) && (ColorNoteSmallScreenUtil.a(paramColorNote.getSubType()) == 4))
      {
        str = "0X800AA83";
        i = 1;
      }
      else
      {
        str = "0X800AA82";
      }
      j = ((IFileManagerUtil)QRoute.api(IFileManagerUtil.class)).getFileType(paramColorNote.getMainTitle());
      if (j != 3) {
        if (j != 4)
        {
          if (j != 6)
          {
            if (j != 7)
            {
              if (j != 9) {
                paramInt = 6;
              } else {
                paramInt = 4;
              }
            }
            else {
              paramInt = 2;
            }
          }
          else {
            paramInt = 3;
          }
        }
        else {
          paramInt = 5;
        }
      }
      if (i != 0) {
        paramInt = 7;
      }
      ReportController.b(null, "dc00898", "", "", str, str, paramInt, 0, "", "", "", "");
      return;
    }
    if (j == 17104896)
    {
      paramColorNote = paramColorNote.getSubType().split("-");
      if (paramColorNote.length > 1) {
        paramInt = Integer.parseInt(paramColorNote[1]);
      } else {
        paramInt = 0;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AA83", "0X800AA83", paramInt, 0, "", "", "", "");
      return;
    }
    if (j == 16908288)
    {
      boolean bool1 = bool2;
      if (paramColorNote.getReserve() != null) {
        try
        {
          bool1 = new JSONObject(new String(paramColorNote.getReserve())).getBoolean("h5_type_read_in_joy");
        }
        catch (JSONException paramColorNote)
        {
          QLog.e("BaseSectionAdapter", 1, paramColorNote, new Object[0]);
          bool1 = bool2;
        }
      }
      if (this.jdField_a_of_type_Int == 17104896)
      {
        if (bool1) {
          paramInt = 9;
        } else {
          paramInt = 8;
        }
        ReportController.b(null, "dc00898", "", "", "0X800AA83", "0X800AA83", paramInt, 0, "", "", "", "");
      }
    }
  }
  
  List<HistoryFormItem> a(Context paramContext)
  {
    Object localObject = new DefaultFormItemBuilder();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((DefaultFormItemBuilder)localObject).a(paramContext, (ColorNote)localIterator.next()));
    }
    int i = 0;
    paramContext = localArrayList.iterator();
    while (paramContext.hasNext())
    {
      localObject = (HistoryFormItem)paramContext.next();
      ((HistoryFormItem)localObject).setIndex(i);
      ((HistoryFormItem)localObject).setItemOnClickListener(new BaseSectionAdapter.1(this, (HistoryFormItem)localObject));
      ((HistoryFormItem)localObject).setOnIconClickListener(new BaseSectionAdapter.2(this, (HistoryFormItem)localObject));
      i += 1;
    }
    return localArrayList;
  }
  
  void a(BaseSectionAdapter.OnDataRefreshListener paramOnDataRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter$OnDataRefreshListener = paramOnDataRefreshListener;
  }
  
  public void a(List<ColorNote> paramList, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter$OnDataRefreshListener.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.BaseSectionAdapter
 * JD-Core Version:    0.7.0.1
 */