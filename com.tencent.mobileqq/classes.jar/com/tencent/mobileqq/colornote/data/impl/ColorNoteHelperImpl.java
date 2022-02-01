package com.tencent.mobileqq.colornote.data.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteDataInjectUtil;
import com.tencent.mobileqq.colornote.data.IColorNoteDataCallback;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.settings.ColorNoteHistoryManager;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ColorNoteHelperImpl
  implements IColorNoteHelper
{
  private static final String TAG = "ColorNoteHelper";
  private static List<IColorNoteDataCallback> dataCallbacks = new ArrayList();
  private AppRuntime appRuntime;
  
  static
  {
    try
    {
      Iterator localIterator = ColorNoteDataInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        dataCallbacks.add(localClass.newInstance());
      }
      CaughtExceptionReport.a(ColorNoteHelperImpl.class.getName());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteHelper", 1, "[static] ", localException);
    }
  }
  
  private void addColorNoteInner(ColorNote paramColorNote)
  {
    boolean bool;
    if (paramColorNote.mExtra == 2) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = getDataService();
    if (localObject == null)
    {
      if (paramColorNote != null) {
        paramColorNote = paramColorNote.toString();
      } else {
        paramColorNote = "note is null";
      }
      QLog.d("ColorNoteHelper", 1, new Object[] { "[addColorNoteInner] ColorNote: ", paramColorNote });
      return;
    }
    paramColorNote.animate = true;
    if (isProxyValidAndCanAddNote(paramColorNote, bool, (IColorNoteDataService)localObject))
    {
      ((IColorNoteDataService)localObject).addColorNote(this.appRuntime.getCurrentUin(), paramColorNote, null, false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addColorNoteInner~~~ ");
        ((StringBuilder)localObject).append(paramColorNote);
        QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject).toString());
      }
      if (paramColorNote.mExtra != 2)
      {
        localObject = ColorNoteSmallScreenUtil.a(MobileQQ.getContext(), this.appRuntime.getCurrentUin());
        bool = ((SharedPreferences)localObject).getBoolean("color_note_permission_music", true);
        int i;
        if (paramColorNote.mServiceType == 16973824) {
          i = 1;
        } else {
          i = 0;
        }
        int j;
        if ((i != 0) && (!bool)) {
          j = 0;
        } else {
          j = 1;
        }
        if (j != 0)
        {
          ColorNoteSmallScreenUtil.a(this.appRuntime, true, false, paramColorNote);
          if (i != 0) {
            ((SharedPreferences)localObject).edit().putBoolean("color_note_permission_music", false).apply();
          }
        }
        if (i != 0) {
          ColorNoteSmallScreenUtil.a(MobileQQ.getContext());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramColorNote = new StringBuilder();
      paramColorNote.append("addColorNoteInner~~~ fail cause count limit, maxCount = ");
      paramColorNote.append(ColorNoteConstants.a);
      paramColorNote.append(" , currCount = ");
      paramColorNote.append(((IColorNoteDataService)localObject).getCurrentColorNoteCount());
      QLog.d("ColorNoteHelper", 2, paramColorNote.toString());
    }
  }
  
  private EIPCResult doIpcCall(String paramString1, String paramString2, Bundle paramBundle)
  {
    paramString2 = QIPCClientHelper.getInstance().getClient().callServer(paramString1, paramString2, paramBundle);
    if (((paramString2 == null) || (paramString2.isSuccess())) && (QLog.isColorLevel()))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("addColorNote eipcResult = ");
      if (paramString2 == null) {
        paramString1 = "null";
      } else {
        paramString1 = Boolean.valueOf(paramString2.isSuccess());
      }
      paramBundle.append(paramString1);
      QLog.d("ColorNoteHelper", 2, paramBundle.toString());
    }
    return paramString2;
  }
  
  private IColorNoteDataService getDataService()
  {
    AppRuntime localAppRuntime = this.appRuntime;
    if (localAppRuntime == null)
    {
      QLog.e("ColorNoteHelper", 1, "[getDataService] appRuntime is null.");
      return null;
    }
    return (IColorNoteDataService)localAppRuntime.getRuntimeService(IColorNoteDataService.class, "all");
  }
  
  private boolean inColorNoteCollection(String paramString, List<ColorNote> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ColorNote)paramList.next()).getUniKey().equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean inMainProcess()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  private static boolean isProxyValidAndCanAddNote(ColorNote paramColorNote, boolean paramBoolean, IColorNoteDataService paramIColorNoteDataService)
  {
    return (paramIColorNoteDataService != null) && ((paramIColorNoteDataService.canAddColorNote()) || (paramBoolean) || (paramColorNote.getServiceType() == 16973824));
  }
  
  private boolean updateRecentNoteInner(ColorNote paramColorNote)
  {
    IColorNoteDataService localIColorNoteDataService = getDataService();
    if (paramColorNote != null) {
      QLog.d("ColorNoteHelper", 1, new Object[] { "[updateRecentNoteInner] data: ", paramColorNote.toString() });
    }
    if (localIColorNoteDataService == null)
    {
      QLog.d("ColorNoteHelper", 1, "[updateRecentNoteInner] runtimeService null.");
      return false;
    }
    ColorNoteSmallScreenUtil.a(this.appRuntime, true, false);
    return localIColorNoteDataService.updateRecentNote(this.appRuntime.getCurrentUin(), paramColorNote);
  }
  
  public boolean addColorNote(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "addColorNote~~~");
    }
    StringBuilder localStringBuilder;
    if (MobileQQ.sProcessId == 1)
    {
      paramBundle = new ColorNote(paramBundle);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addColorNote~~~ main ");
        localStringBuilder.append(paramBundle.toString());
        QLog.d("ColorNoteHelper", 2, localStringBuilder.toString());
      }
      addColorNoteInner(paramBundle);
      return true;
    }
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_add_colornote", paramBundle);
    if ((paramBundle != null) && (paramBundle.isSuccess())) {
      return paramBundle.data.getBoolean("extra_add_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addColorNote eipcResult = ");
      if (paramBundle == null) {
        paramBundle = "null";
      } else {
        paramBundle = Boolean.valueOf(paramBundle.isSuccess());
      }
      localStringBuilder.append(paramBundle);
      QLog.d("ColorNoteHelper", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean canAddColorNote()
  {
    if (MobileQQ.sProcessId == 1)
    {
      localObject = getDataService();
      if (localObject != null) {
        return ((IColorNoteDataService)localObject).canAddColorNote();
      }
      QLog.d("ColorNoteHelper", 1, "[canAddColorNote] in main process, cannot get runtimeService");
      return false;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_can_add_colornote", null);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("extra_can_add_colornote", true);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteColorNote eipcResult = ");
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess());
      }
      localStringBuilder.append(localObject);
      QLog.d("ColorNoteHelper", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  protected boolean canAddColorNoteInner()
  {
    int i = MobileQQ.sProcessId;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i == 1)
    {
      Object localObject = getDataService();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((IColorNoteDataService)localObject).canAddColorNote()) {
          bool1 = true;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[canAddColorNoteInner] canAddColorNote: ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public boolean clearHistoryNote(int paramInt)
  {
    if (MobileQQ.sProcessId == 1)
    {
      ColorNoteHistoryManager.d(this.appRuntime, paramInt);
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("color_note_service_type", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_history_color_notes", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("extra_clear_history_succ", false);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearHistoryNote eipcResult = ");
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess());
      }
      localStringBuilder.append(localObject);
      QLog.d("ColorNoteHelper", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void deleteAllColorNote(AppRuntime paramAppRuntime, ProxyListener paramProxyListener)
  {
    IColorNoteDataService localIColorNoteDataService = getDataService();
    if (localIColorNoteDataService == null)
    {
      QLog.d("ColorNoteHelper", 2, "[deleteAllColorNote] runtimeService null");
      return;
    }
    paramAppRuntime = localIColorNoteDataService.deleteAllColorNote(paramAppRuntime.getCurrentAccountUin(), paramProxyListener);
    paramProxyListener = dataCallbacks.iterator();
    while (paramProxyListener.hasNext()) {
      ((IColorNoteDataCallback)paramProxyListener.next()).a(paramAppRuntime);
    }
  }
  
  public boolean deleteColorNote(int paramInt, String paramString)
  {
    return deleteColorNote(paramInt, paramString, 0);
  }
  
  public boolean deleteColorNote(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt1));
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt2);
    return deleteColorNote(localStringBuilder.toString(), paramInt2);
  }
  
  public boolean deleteColorNote(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "deleteColorNote~~~");
    }
    if (MobileQQ.sProcessId == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteColorNote~~~ main key");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject).toString());
      }
      deleteColorNoteInner(paramString, paramInt);
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    ((Bundle)localObject).putInt("color_note_extra_type", paramInt);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_delete_colornote", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getBoolean("extra_delete_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteColorNote eipcResult = ");
      if (paramString == null) {
        paramString = "null";
      } else {
        paramString = Boolean.valueOf(paramString.isSuccess());
      }
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  protected void deleteColorNoteInner(String paramString, int paramInt)
  {
    Object localObject1 = getDataService();
    if (localObject1 != null)
    {
      paramString = ((IColorNoteDataService)localObject1).findColorNoteByKey(paramString, paramInt);
    }
    else
    {
      QLog.d("ColorNoteHelper", 1, new Object[] { "[deleteColorNoteInner] runtimeService null, key: ", paramString });
      paramString = null;
    }
    if (paramString == null) {
      return;
    }
    ((IColorNoteDataService)localObject1).deleteColorNote(this.appRuntime.getCurrentUin(), paramString, null);
    ColorNoteSmallScreenUtil.a(this.appRuntime.getApp(), 3, false);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString.getServiceType());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    String str = paramString.getSubType();
    Intent localIntent = new Intent("key_delete_item_call");
    localIntent.putExtra("key_color_note_servicetype_list", new String[] { localObject2 });
    localIntent.putExtra("key_color_note_suptype_list", new String[] { str });
    localIntent.putExtra("extra_can_add_colornote", ((IColorNoteDataService)localObject1).canAddColorNote());
    localIntent.putExtras(paramString.parseBundle());
    MobileQQ.getContext().sendBroadcast(localIntent);
    localObject1 = dataCallbacks.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IColorNoteDataCallback)((Iterator)localObject1).next()).a(paramString);
    }
  }
  
  public boolean isColorNoteExit(int paramInt, String paramString)
  {
    return isColorNoteExit(paramInt, paramString, 0);
  }
  
  public boolean isColorNoteExit(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isColorNoteExit~~~ serviceType = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", subType = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(paramInt1));
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(paramInt2);
    paramString = ((StringBuilder)localObject).toString();
    if (MobileQQ.sProcessId == 1)
    {
      localObject = getDataService();
      if (localObject != null)
      {
        localObject = ((IColorNoteDataService)localObject).getColorNotes(false).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((ColorNote)((Iterator)localObject).next()).getUniKey().equals(paramString))
          {
            bool = true;
            break label169;
          }
        }
      }
      boolean bool = false;
      label169:
      QLog.d("ColorNoteHelper", 2, new Object[] { "isColorNoteExit main ~~~ result = ", Boolean.valueOf(bool), ", key: ", paramString });
      return bool;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_query_isexists", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getBoolean("extra_is_colornote_exists", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isColorNoteExit eipcResult = ");
      if (paramString == null) {
        paramString = "null";
      } else {
        paramString = Boolean.valueOf(paramString.isSuccess());
      }
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean isColorNoteExit(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start search. key: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool2 = inMainProcess();
    boolean bool1 = false;
    if (bool2)
    {
      localObject = getDataService();
      if (localObject != null) {
        return inColorNoteCollection(paramString, ((IColorNoteDataService)localObject).getColorNotes(false));
      }
      QLog.d("ColorNoteHelper", 1, new Object[] { "[isColorNoteExist] key: ", paramString });
      return false;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    paramString = doIpcCall("ColorNoteIPCServer", "cmd_query_isexists", (Bundle)localObject);
    if (paramString != null) {
      bool1 = paramString.data.getBoolean("extra_is_colornote_exists", false);
    }
    return bool1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
    QLog.d("ColorNoteHelper", 1, new Object[] { "[onCreate] appRuntime: ", this.appRuntime });
  }
  
  public void onDestroy()
  {
    QLog.d("ColorNoteHelper", 1, new Object[] { "[onDestroy] appRuntime: ", this.appRuntime });
    this.appRuntime = null;
  }
  
  public boolean updateColorNote(String paramString1, String paramString2, Object paramObject)
  {
    return updateColorNote(paramString1, paramString2, paramObject, 0);
  }
  
  public boolean updateColorNote(String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "updateColorNote~~~");
    }
    if (MobileQQ.sProcessId == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateColorNote~~~ main[ uniKey = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", fieldName = ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(", fieldValue = ");
        ((StringBuilder)localObject).append(paramObject);
        ((StringBuilder)localObject).append("]");
        QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject).toString());
      }
      return updateColorNoteInner(paramString1, paramString2, paramObject);
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString1);
    ((Bundle)localObject).putString("extra_field_name", paramString2);
    if (paramInt == 0) {
      ((Bundle)localObject).putString("extra_field_value", (String)paramObject);
    } else if (paramInt == 1) {
      ((Bundle)localObject).putByteArray("extra_field_value", (byte[])paramObject);
    }
    paramString1 = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote", (Bundle)localObject);
    if ((paramString1 != null) && (paramString1.isSuccess())) {
      return paramString1.data.getBoolean("extra_update_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("updateColorNote eipcResult = ");
      if (paramString1 == null) {
        paramString1 = "null";
      } else {
        paramString1 = Boolean.valueOf(paramString1.isSuccess());
      }
      paramString2.append(paramString1);
      QLog.d("ColorNoteHelper", 2, paramString2.toString());
    }
    return false;
  }
  
  protected boolean updateColorNoteInner(String paramString1, String paramString2, Object paramObject)
  {
    int i = MobileQQ.sProcessId;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1)
    {
      IColorNoteDataService localIColorNoteDataService = getDataService();
      ColorNote localColorNote = null;
      if (localIColorNoteDataService != null) {
        localColorNote = localIColorNoteDataService.updateColorNoteFieldByKey(this.appRuntime.getCurrentUin(), paramString1, paramString2, paramObject);
      }
      bool1 = bool2;
      if (localColorNote != null) {
        bool1 = true;
      }
    }
    paramString2 = new StringBuilder();
    paramString2.append("updateColorNoteInner~~~ unikey ");
    paramString2.append(paramString1);
    paramString2.append(", result");
    paramString2.append(bool1);
    QLog.d("ColorNoteHelper", 2, paramString2.toString());
    return bool1;
  }
  
  public Bundle updateColorNoteState(int paramInt, String paramString, boolean paramBoolean)
  {
    return updateColorNoteState(paramInt, paramString, paramBoolean, 0);
  }
  
  public Bundle updateColorNoteState(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt1));
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt2);
    return updateColorNoteState(localStringBuilder.toString(), paramBoolean);
  }
  
  public Bundle updateColorNoteState(String paramString, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      QLog.d("ColorNoteHelper", 2, "updateColorNote~~~");
    }
    Bundle localBundle = new Bundle();
    if (MobileQQ.sProcessId == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateColorNote~~~ key ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = null;
      localObject2 = getDataService();
      bool = false;
      if (localObject2 != null)
      {
        paramString = ((IColorNoteDataService)localObject2).findColorNoteByKey(paramString);
      }
      else
      {
        QLog.d("ColorNoteHelper", 1, new Object[] { "[updateColorNoteState] runtimeService null, key: ", paramString });
        paramString = (String)localObject1;
      }
      if (paramString != null)
      {
        if (!paramBoolean) {
          i = 1;
        }
        paramString.setState(i);
      }
      paramBoolean = bool;
      if (paramString != null) {
        paramBoolean = true;
      }
      localBundle.putBoolean("extra_is_colornote_exists", paramBoolean);
      localBundle.putBoolean("extra_can_add_colornote", canAddColorNoteInner());
      localBundle.putBoolean("extra_after_sync_msg", ColorNoteSmallScreenUtil.b());
      paramString = ColorNoteSmallScreenUtil.a(this.appRuntime);
      localBundle.putInt("key_float_window_position_x", paramString.x);
      localBundle.putInt("key_float_window_position_y", paramString.y);
      paramString = this.appRuntime;
      if (paramString != null)
      {
        ColorNoteSmallScreenUtil.a(paramString.getApp(), 3, true);
        return localBundle;
      }
      CaughtExceptionReport.a(new IllegalStateException("ColorNote AppRuntime null."));
      return localBundle;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("extra_unikey", paramString);
    ((Bundle)localObject1).putBoolean("extra_update_colornote_state", paramBoolean);
    Object localObject2 = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote_state", (Bundle)localObject1);
    if ((localObject2 != null) && (((EIPCResult)localObject2).isSuccess()))
    {
      localBundle = ((EIPCResult)localObject2).data;
      paramString = localBundle;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("receive from ipc server: ");
        paramString.append(localObject1);
        QLog.d("ColorNoteHelper", 2, paramString.toString());
        return localBundle;
      }
    }
    else
    {
      paramString = localBundle;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateColorNote eipcResult = ");
        if (localObject2 == null) {
          paramString = "null";
        } else {
          paramString = Boolean.valueOf(((EIPCResult)localObject2).isSuccess());
        }
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ColorNoteHelper", 2, ((StringBuilder)localObject1).toString());
        paramString = localBundle;
      }
    }
    return paramString;
  }
  
  public boolean updateRecentNote(ColorNote paramColorNote)
  {
    if (MobileQQ.sProcessId == 1) {
      return updateRecentNoteInner(paramColorNote);
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putSerializable("color_note_recently_viewed_comparator", paramColorNote);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_color_note", (Bundle)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, new Object[] { "[updateRecentNote] call from ", Integer.valueOf(MobileQQ.sProcessId), ", data: ", paramColorNote.toString() });
    }
    return ((EIPCResult)localObject).isSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.impl.ColorNoteHelperImpl
 * JD-Core Version:    0.7.0.1
 */