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
    int i = this.observers.length;
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = new SubjectSubscriptionManager.SubjectObserver[i + 1];
    System.arraycopy(this.observers, 0, arrayOfSubjectObserver, 0, i);
    arrayOfSubjectObserver[i] = paramSubjectObserver;
    return new State(this.terminated, arrayOfSubjectObserver);
  }
  
  public State remove(SubjectSubscriptionManager.SubjectObserver paramSubjectObserver)
  {
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver2 = this.observers;
    int m = arrayOfSubjectObserver2.length;
    State localState;
    if ((m == 1) && (arrayOfSubjectObserver2[0] == paramSubjectObserver)) {
      localState = EMPTY;
    }
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver1;
    int j;
    SubjectSubscriptionManager.SubjectObserver localSubjectObserver;
    do
    {
      do
      {
        return localState;
        localState = this;
      } while (m == 0);
      arrayOfSubjectObserver1 = new SubjectSubscriptionManager.SubjectObserver[m - 1];
      j = 0;
      i = 0;
      if (j >= m) {
        break;
      }
      localSubjectObserver = arrayOfSubjectObserver2[j];
      if (localSubjectObserver == paramSubjectObserver) {
        break label153;
      }
      localState = this;
    } while (i == m - 1);
    int k = i + 1;
    arrayOfSubjectObserver1[i] = localSubjectObserver;
    int i = k;
    label153:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        return EMPTY;
      }
      if (i < m - 1)
      {
        paramSubjectObserver = new SubjectSubscriptionManager.SubjectObserver[i];
        System.arraycopy(arrayOfSubjectObserver1, 0, paramSubjectObserver, 0, i);
      }
      for (;;)
      {
        return new State(this.terminated, paramSubjectObserver);
        paramSubjectObserver = arrayOfSubjectObserver1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.subjects.SubjectSubscriptionManager.State
 * JD-Core Version:    0.7.0.1
 */