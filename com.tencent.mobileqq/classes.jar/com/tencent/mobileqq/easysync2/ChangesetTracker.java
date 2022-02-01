package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.easysync2.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Iterator;

public class ChangesetTracker
  implements IChangesetTracker
{
  protected AText a;
  protected AttribPool a;
  private EditorCallback jdField_a_of_type_ComTencentMobileqqEasysync2EditorCallback;
  private UserChangeCallback jdField_a_of_type_ComTencentMobileqqEasysync2UserChangeCallback;
  protected String a;
  private boolean jdField_a_of_type_Boolean = false;
  protected String b;
  private boolean b;
  
  public ChangesetTracker(AttribPool paramAttribPool, EditorCallback paramEditorCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEasysync2AText = Changeset.a("\n", null);
    this.jdField_b_of_type_JavaLangString = Changeset.b(1);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool = paramAttribPool;
    this.jdField_a_of_type_ComTencentMobileqqEasysync2EditorCallback = paramEditorCallback;
  }
  
  private String a(String paramString)
  {
    Object localObject1 = "";
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool.a.size())
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool.a.keyAt(i);
      Pair localPair = (Pair)this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool.a.get(j);
      Object localObject2 = localObject1;
      if (((String)localPair.first).equals("author"))
      {
        localObject2 = localObject1;
        if (((String)localPair.second).equals(paramString)) {
          localObject2 = Integer.toString(j, Changeset.jdField_a_of_type_Int);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  @NonNull
  private String a(String paramString, Changeset paramChangeset)
  {
    paramChangeset = Changeset.a(paramChangeset.jdField_a_of_type_JavaLangString);
    MergingOpAssembler localMergingOpAssembler = new MergingOpAssembler();
    while (paramChangeset.hasNext())
    {
      Operation localOperation = (Operation)paramChangeset.next();
      if (localOperation.jdField_a_of_type_Char == '+')
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = localOperation.jdField_a_of_type_JavaLangString.split("\\*");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!Utils.a(str))
          {
            Pair localPair = this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool.a(Integer.parseInt(str, Changeset.jdField_a_of_type_Int));
            if (localPair != null) {
              if ("author".equals(localPair.first))
              {
                localStringBuilder.append('*');
                localStringBuilder.append(paramString);
              }
              else
              {
                localStringBuilder.append('*');
                localStringBuilder.append(str);
              }
            }
          }
          i += 1;
        }
        localOperation.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      }
      localMergingOpAssembler.a(localOperation);
    }
    localMergingOpAssembler.b();
    return localMergingOpAssembler.toString();
  }
  
  public AttribPool a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool;
  }
  
  public UserChangeData a(String paramString)
  {
    boolean bool = Utils.a(this.jdField_a_of_type_JavaLangString);
    AttribPool localAttribPool = null;
    if (!bool)
    {
      paramString = Changeset.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool.a != null)
      {
        str = a(paramString);
        paramString = Changeset.a(this.jdField_b_of_type_JavaLangString);
        str = a(str, paramString);
        this.jdField_b_of_type_JavaLangString = Changeset.a(paramString.jdField_b_of_type_Int, paramString.c, str, paramString.jdField_b_of_type_JavaLangString);
        Changeset.a(this.jdField_b_of_type_JavaLangString);
      }
      if (Changeset.a(this.jdField_b_of_type_JavaLangString)) {
        paramString = null;
      } else {
        paramString = this.jdField_b_of_type_JavaLangString;
      }
    }
    if (!Utils.a(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_JavaLangString = Changeset.b(Changeset.b(paramString));
    }
    else
    {
      paramString = null;
    }
    String str = paramString;
    if (!Utils.a(paramString))
    {
      paramString = Changeset.a(paramString, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
      localAttribPool = paramString.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool;
      str = paramString.jdField_a_of_type_JavaLangString;
    }
    return new UserChangeData(str, localAttribPool);
  }
  
  public void a()
  {
    if (!Utils.a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WriteTogether applying committed changeset: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.i("ChangesetTracker", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqEasysync2AText = Changeset.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqEasysync2AText, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    throw new IllegalStateException("applySubmittedChangesToBase: no submitted changes to apply");
  }
  
  public void a(AText paramAText, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WriteTogether|setBaseAttributedText: ");
      ((StringBuilder)localObject).append(paramAText.jdField_a_of_type_JavaLangString);
      QLog.i("ChangesetTracker", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqEasysync2AText = Changeset.a(paramAText);
    if (!Utils.a(paramString))
    {
      paramString = AttribPool.a(paramString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqEasysync2AText;
      ((AText)localObject).jdField_b_of_type_JavaLangString = Changeset.a(((AText)localObject).jdField_b_of_type_JavaLangString, paramString, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = Changeset.b(paramAText.jdField_a_of_type_JavaLangString.length());
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEasysync2EditorCallback.a(paramAText);
      return;
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(UserChangeCallback paramUserChangeCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEasysync2UserChangeCallback = paramUserChangeCallback;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (Changeset.a(paramString)) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = Changeset.b(this.jdField_b_of_type_JavaLangString, paramString, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    paramString = this.jdField_a_of_type_ComTencentMobileqqEasysync2UserChangeCallback;
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void a(String paramString1, String paramString2, AttribPool paramAttribPool)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    String str = paramString1;
    if (paramAttribPool != null) {
      str = Changeset.a(paramString1, paramAttribPool, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("WriteTogether|applyChangesToBase: ");
      paramString1.append(this.jdField_a_of_type_ComTencentMobileqqEasysync2AText.jdField_a_of_type_JavaLangString);
      QLog.i("ChangesetTracker", 2, paramString1.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqEasysync2AText = Changeset.a(str, this.jdField_a_of_type_ComTencentMobileqqEasysync2AText, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    paramString1 = str;
    if (!Utils.a(this.jdField_a_of_type_JavaLangString))
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaLangString = Changeset.b(str, paramString1, false, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
      paramString1 = Changeset.b(paramString1, str, true, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    }
    paramAttribPool = this.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = Changeset.b(paramString1, paramAttribPool, true, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    paramString1 = Changeset.b(paramAttribPool, paramString1, false, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEasysync2EditorCallback.a(paramString1, true, paramString2);
      return;
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    return (!Utils.a(this.jdField_a_of_type_JavaLangString)) || (!Changeset.a(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean b()
  {
    return Utils.a(this.jdField_a_of_type_JavaLangString) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.ChangesetTracker
 * JD-Core Version:    0.7.0.1
 */