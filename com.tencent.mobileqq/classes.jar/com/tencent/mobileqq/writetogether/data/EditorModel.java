package com.tencent.mobileqq.writetogether.data;

import android.text.TextUtils;
import com.tencent.mobileqq.easysync2.AText;
import com.tencent.mobileqq.easysync2.AttribPool;
import com.tencent.mobileqq.easysync2.Changeset;
import com.tencent.mobileqq.writetogether.client.IEditorController;
import com.tencent.mobileqq.writetogether.client.IPartChangeListener;
import com.tencent.mobileqq.writetogether.client.UserStateController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EditorModel
  implements IEditorModel
{
  private int jdField_a_of_type_Int = 10000;
  private long jdField_a_of_type_Long;
  private AText jdField_a_of_type_ComTencentMobileqqEasysync2AText;
  private AttribPool jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool;
  private IEditorController jdField_a_of_type_ComTencentMobileqqWritetogetherClientIEditorController;
  private IPartChangeListener jdField_a_of_type_ComTencentMobileqqWritetogetherClientIPartChangeListener;
  private UserStateController jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController;
  private CursorManager jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager;
  private DocMetaData jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData;
  private String jdField_a_of_type_JavaLangString = "";
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new TreeMap();
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private Map<String, String> jdField_b_of_type_JavaUtilMap = new TreeMap();
  private String c = "";
  private String d = "";
  private String e;
  
  public EditorModel(AText paramAText, AttribPool paramAttribPool, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqEasysync2AText = paramAText;
    this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool = paramAttribPool;
    this.jdField_b_of_type_JavaLangString = paramString1;
  }
  
  private void a(String paramString1, String paramString2)
  {
    boolean bool = this.jdField_b_of_type_JavaLangString.equals(paramString1);
    if (!bool)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramString1);
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      this.jdField_b_of_type_JavaUtilList.remove(paramString1);
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
      long l = b();
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, Long.valueOf(l));
      b(this.jdField_a_of_type_JavaUtilList);
      b(this.jdField_b_of_type_JavaUtilList);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIPartChangeListener;
      if (localObject != null) {
        ((IPartChangeListener)localObject).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, true);
      }
    }
    this.e = paramString1;
    this.jdField_a_of_type_Long = b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController;
    if (localObject != null)
    {
      if (!bool) {
        ((UserStateController)localObject).b();
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqEasysync2AText.jdField_a_of_type_JavaLangString.length());
    }
    if (!bool) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager.b(paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager.a(paramString1, paramString2);
  }
  
  private long b()
  {
    return System.currentTimeMillis();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIPartChangeListener != null)
    {
      boolean bool;
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      List localList;
      if (bool) {
        localList = this.jdField_a_of_type_JavaUtilList;
      } else {
        localList = this.jdField_b_of_type_JavaUtilList;
      }
      b(localList);
      IPartChangeListener localIPartChangeListener = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIPartChangeListener;
      String str = this.jdField_a_of_type_JavaLangString;
      if (bool) {
        localList = this.jdField_a_of_type_JavaUtilList;
      } else {
        localList = this.jdField_b_of_type_JavaUtilList;
      }
      localIPartChangeListener.a(str, localList, bool);
    }
  }
  
  private void b(List<String> paramList)
  {
    Collections.sort(paramList, new EditorModel.1(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public AText a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEasysync2AText;
  }
  
  public AttribPool a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool;
  }
  
  public CreateDocParam a()
  {
    CreateDocParam localCreateDocParam = new CreateDocParam();
    localCreateDocParam.d = this.jdField_a_of_type_ComTencentMobileqqEasysync2AText.jdField_a_of_type_JavaLangString;
    localCreateDocParam.e = this.jdField_a_of_type_ComTencentMobileqqEasysync2AText.jdField_b_of_type_JavaLangString;
    localCreateDocParam.c = this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool.a();
    return localCreateDocParam;
  }
  
  public DocMetaData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData;
  }
  
  public Pair<Integer, Integer> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager.a();
  }
  
  public String a()
  {
    return this.e;
  }
  
  public String a(String paramString)
  {
    Map localMap = this.jdField_b_of_type_JavaUtilMap;
    if (localMap != null) {
      return (String)localMap.get(paramString);
    }
    return null;
  }
  
  public List<UserEditInfo> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager.a();
  }
  
  public void a()
  {
    IPartChangeListener localIPartChangeListener = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIPartChangeListener;
    if (localIPartChangeListener != null) {
      localIPartChangeListener.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilList, false);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    CursorManager localCursorManager = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager;
    if (localCursorManager != null) {
      localCursorManager.a(paramInt1, paramInt2, false);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(AText paramAText)
  {
    AText localAText = paramAText;
    if (paramAText == null) {
      localAText = new AText("", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqEasysync2AText = localAText;
  }
  
  public void a(AttribPool paramAttribPool)
  {
    AttribPool localAttribPool = paramAttribPool;
    if (paramAttribPool == null) {
      localAttribPool = new AttribPool();
    }
    this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool = localAttribPool;
  }
  
  public void a(IEditorController paramIEditorController)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIEditorController = paramIEditorController;
  }
  
  public void a(IPartChangeListener paramIPartChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIPartChangeListener = paramIPartChangeListener;
  }
  
  public void a(UserStateController paramUserStateController)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController = paramUserStateController;
  }
  
  public void a(CursorManager paramCursorManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager = paramCursorManager;
  }
  
  public void a(DocMetaData paramDocMetaData)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData = paramDocMetaData;
    this.jdField_a_of_type_JavaLangString = paramDocMetaData.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramDocMetaData.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_Long <= 0L) && (QLog.isColorLevel())) {
      QLog.e("EditorModel", 2, "metaData.mTime lt 0");
    }
    paramDocMetaData = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController;
    if (paramDocMetaData != null) {
      paramDocMetaData.b();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    b();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager.a(paramString, paramInt1, paramInt2);
    if (!paramString.equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramString);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
      long l = b();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
      b();
    }
  }
  
  public void a(String paramString, long paramLong, UserEditInfo paramUserEditInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      b();
      if (!paramUserEditInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager.a(paramString, paramUserEditInfo);
      }
      return;
    }
    paramUserEditInfo = new StringBuilder();
    paramUserEditInfo.append("[addParticipant error] author: ");
    paramUserEditInfo.append(paramString);
    paramUserEditInfo.append(", aliveTimeSec: ");
    paramUserEditInfo.append(paramLong);
    QLog.e("EditorModel", 1, paramUserEditInfo.toString());
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[new changeset] - notifyView: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", cs: ");
      localStringBuilder.append(paramString1);
      QLog.d("EditorModel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqEasysync2AText = Changeset.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqEasysync2AText, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIEditorController.a(this.jdField_a_of_type_ComTencentMobileqqEasysync2AText.jdField_a_of_type_JavaLangString);
    }
    a(paramString2, paramString1);
  }
  
  public void a(List<EditUserHistory> paramList)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditorModel", 2, "histories is null");
      }
      return;
    }
    if ((paramList.size() == 0) && (QLog.isColorLevel())) {
      QLog.d("EditorModel", 2, "histories size is 0");
    }
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EditUserHistory localEditUserHistory = (EditUserHistory)paramList.next();
      if (localEditUserHistory != null)
      {
        String str = localEditUserHistory.jdField_a_of_type_JavaLangString;
        long l = localEditUserHistory.jdField_a_of_type_Long * 1000L;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[setEditUserHistory] uin: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", editTime: ");
          ((StringBuilder)localObject).append(l);
          QLog.d("EditorModel", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_b_of_type_JavaUtilList.add(str);
        this.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l));
        Object localObject = this.jdField_b_of_type_JavaUtilMap;
        if (localObject != null) {
          ((Map)localObject).put(str, localEditUserHistory.jdField_b_of_type_JavaLangString);
        }
      }
    }
    b(this.jdField_b_of_type_JavaUtilList);
    if (this.jdField_b_of_type_JavaUtilList.size() != 0)
    {
      this.e = ((String)this.jdField_b_of_type_JavaUtilList.get(0));
      paramList = (Long)this.jdField_a_of_type_JavaUtilMap.get(this.e);
      if (paramList != null) {
        this.jdField_a_of_type_Long = paramList.longValue();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataCursorManager.a(paramBoolean);
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.EditorModel
 * JD-Core Version:    0.7.0.1
 */