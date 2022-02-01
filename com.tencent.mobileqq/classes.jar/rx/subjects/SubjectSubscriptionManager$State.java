package rx.subjects;

public final class SubjectSubscriptionManager$State<T>
{
  static final State EMPTY = new State(false, NO_OBSERVERS);
  static final SubjectSubscriptionManager.SubjectObserver[] NO_OBSERVERS = new SubjectSubscriptionManager.SubjectObserver[0];
  static final State TERMINATED = new State(true, NO_OBSERVERS);
  final SubjectSubscriptionManager.SubjectObserver[] observers;
  final boolean terminated;
  
  public SubjectSubscriptionManager$State(boolean paramBoolean, SubjectSubscriptionManager.SubjectObserver[] paramArrayOfSubjectObserver)
  {
    this.terminated = paramBoolean;
    this.observers = paramArrayOfSubjectObserver;
  }
  
  public State add(SubjectSubscriptionManager.SubjectObserver paramSubjectObserver)
  {
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver1 = this.observers;
    int i = arrayOfSubjectObserver1.length;
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver2 = new SubjectSubscriptionManager.SubjectObserver[i + 1];
    System.arraycopy(arrayOfSubjectObserver1, 0, arrayOfSubjectObserver2, 0, i);
    arrayOfSubjectObserver2[i] = paramSubjectObserver;
    return new State(this.terminated, arrayOfSubjectObserver2);
  }
  
  public State remove(SubjectSubscriptionManager.SubjectObserver paramSubjectObserver)
  {
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver2 = this.observers;
    int m = arrayOfSubjectObserver2.length;
    if ((m == 1) && (arrayOfSubjectObserver2[0] == paramSubjectObserver)) {
      return EMPTY;
    }
    if (m == 0) {
      return this;
    }
    int n = m - 1;
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver1 = new SubjectSubscriptionManager.SubjectObserver[n];
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver2[i];
      k = j;
      if (localSubjectObserver != paramSubjectObserver)
      {
        if (j == n) {
          return this;
        }
        arrayOfSubjectObserver1[j] = localSubjectObserver;
        k = j + 1;
      }
      i += 1;
    }
    if (j == 0) {
      return EMPTY;
    }
    if (j < n)
    {
      paramSubjectObserver = new SubjectSubscriptionManager.SubjectObserver[j];
      System.arraycopy(arrayOfSubjectObserver1, 0, paramSubjectObserver, 0, j);
    }
    else
    {
      paramSubjectObserver = arrayOfSubjectObserver1;
    }
    return new State(this.terminated, paramSubjectObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subjects.SubjectSubscriptionManager.State
 * JD-Core Version:    0.7.0.1
 */